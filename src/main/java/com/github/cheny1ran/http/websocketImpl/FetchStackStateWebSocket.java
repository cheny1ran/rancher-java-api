package com.github.cheny1ran.http.websocketImpl;

import com.alibaba.fastjson.JSON;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.dataobject.RancherWSObject;
import com.github.cheny1ran.http.RancherWebSocket;
import com.github.cheny1ran.model.Service;
import com.github.cheny1ran.model.Stack;
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

    /**
     * 返回部署结果是成功还是失败
     */
    private boolean result = false;

    @Override
    public void onMessage(String msg) {

        RancherWSObject wsObject = JSON.parseObject(msg, RancherWSObject.class);
        if (wsObject.getData().get(RancherDataType.RESOURCE) == null) return;
        String dataStr = wsObject.getData().get(RancherDataType.RESOURCE).toString();

        if (stackId == null) {
            log.error("未设置监听的 stackId !结束监听.");
            this.session.close();
        }

        boolean flag = false;

        if (wsObject.getName().equals(RancherDataType.RESOURCE_CHANGE_EVENT)) {
            if (!flag && wsObject.getResourceType().equals(RancherDataType.STACK)) {
                // stack创建成功但服务未启动
                Stack stackDataResource = JSON.parseObject(dataStr, Stack.class);
                if (stackDataResource.getState().equals(RancherDataType.ACTIVE) &&
                        stackDataResource.getHealthState().equals(RancherDataType.HEALTHY) &&
                        stackDataResource.getTransitioning().equals(RancherDataType.TRANSITIONING_NO)) {

                    log.info("Stack id = " + stackId + " 创建成功");
                    flag = true;
                }

            }
            // stack状态在service未完全好前就会设置成成功
            // 若 service transitioning 已经 error 则快速失败
            if (wsObject.getResourceType().equals(RancherDataType.SERVICE)) {
                Service serviceDataResource = JSON.parseObject(dataStr, Service.class);

                if (serviceDataResource.getStackId().equals(stackId)) {
                    if (serviceDataResource.getTransitioning().equals(RancherDataType.TRANSITIONING_ERROR)) {
                        this.session.close();
                    }
                }

                if (serviceDataResource.getState().equals(RancherDataType.UPGRADED) &&
                        serviceDataResource.getHealthState().equals(RancherDataType.HEALTHY) &&
                        serviceDataResource.getTransitioning().equals(RancherDataType.TRANSITIONING_NO) &&
                        serviceDataResource.getStackId().equals(stackId)) {

                    log.info("Got stack " + stackId + " service deployed " + serviceDataResource.getId());
                    result = true;
                    this.session.close();
                }
            }
        }
    }

    public boolean getResult() {
        return result;
    }
}
