package com.github.cheny1ran.http.websocketImpl;

import com.alibaba.fastjson.JSON;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.dataobject.RancherWSObject;
import com.github.cheny1ran.http.RancherWebSocket;
import com.github.cheny1ran.model.websocket.ServiceDataResource;
import com.github.cheny1ran.model.websocket.StackDataResource;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * 功能描述:
 * websocket to listen a stack state
 * when stack state:active + healthState:healthy + transitioning:no means success
 *
 * @Author chen.yiran
 * @Date 17/3/17.
 */

@WebSocket
public class FetchStackStateWebSocket extends RancherWebSocket {

    private final String stackId;

    private final Logger log = Logger.getLogger(FetchStackStateWebSocket.class);

    public FetchStackStateWebSocket(String stackId) {
        this.stackId = stackId;
    }

    public FetchStackStateWebSocket(String stackId, boolean isCreate) {
        this.stackId = stackId;
        this.create = isCreate;
    }

    /**
     * stack deploy result
     */
    private boolean result = false;

    private boolean create = true;

    public void updateMode() {
        this.create = false;
    }

    public void createMode() {
        this.create = true;
    }

    @Override
    public void onMessage(String msg) {

        RancherWSObject wsObject = JSON.parseObject(msg, RancherWSObject.class);
        if (wsObject.getData().get(RancherDataType.RESOURCE) == null) return;
        String dataStr = wsObject.getData().get(RancherDataType.RESOURCE).toString();

        if (stackId == null) {
            log.error("StackId is null! End listening.");
            this.session.close();
        }
        if (wsObject.getName().equals(RancherDataType.RESOURCE_CHANGE_EVENT)) {

            if (create) {
                if (wsObject.getResourceType().equals(RancherDataType.STACK)) {
                    if (stackCreated(dataStr)) {
                        log.info("Stack id = " + stackId + " created!");
                        result = true;
                        this.session.close();
                    }
                }
            } else {
                if (wsObject.getResourceType().equals(RancherDataType.SERVICE)) {

                    if (serviceError(dataStr)) {
                        this.session.close();
                    }

                    if (serviceUpgraded(dataStr)) {
                        log.info("Got stack " + stackId + " service deployed ");
                        result = true;
                        this.session.close();
                    }
                }
            }
        }
    }

    public boolean getResult() {
        return result;
    }

    private boolean stackCreated(String dataStr) {
        StackDataResource stackDataResource = JSON.parseObject(dataStr, StackDataResource.class);
        return stackDataResource.getState().equals(RancherDataType.ACTIVE) &&
                stackDataResource.getHealthState().equals(RancherDataType.HEALTHY) &&
                stackDataResource.getTransitioning().equals(RancherDataType.TRANSITIONING_NO);


    }

    private boolean serviceError(String dataStr) {
        ServiceDataResource serviceDataResource = JSON.parseObject(dataStr, ServiceDataResource.class);
        return serviceDataResource.getStackId().equals(stackId) &&
                serviceDataResource.getTransitioning().equals(RancherDataType.TRANSITIONING_ERROR);
    }

    private boolean serviceUpgraded(String dataStr) {
        ServiceDataResource serviceDataResource = JSON.parseObject(dataStr, ServiceDataResource.class);
        return serviceDataResource.getState().equals(RancherDataType.UPGRADED) &&
                serviceDataResource.getHealthState().equals(RancherDataType.HEALTHY) &&
                serviceDataResource.getTransitioning().equals(RancherDataType.TRANSITIONING_NO) &&
                serviceDataResource.getStackId().equals(stackId);
    }
}
