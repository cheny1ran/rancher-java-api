package com.github.cheny1ran.http;

import com.alibaba.fastjson.JSON;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.dataobject.RancherWSDataResource;
import com.github.cheny1ran.dataobject.RancherWSObject;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */

@WebSocket
public class DefaultRancherWebSocket extends RancherWebSocket {

    private final static Logger log = Logger.getLogger(DefaultRancherWebSocket.class);


    private final String containerId;

    public DefaultRancherWebSocket(String containerId) {
        this.containerId = containerId;
    }

    @Override
    public void onMessage(String msg) {
        RancherWSObject rancherObject = JSON.parseObject(msg, RancherWSObject.class);
        if (rancherObject.getName().equals(RancherDataType.RESOURCE_CHANGE_EVENT)) {

            String resourceStr = rancherObject.getData().get("resource").toString();
            RancherWSDataResource resource = JSON.parseObject(resourceStr, RancherWSDataResource.class);
            if (containerId == null) {
                log.info("Got message : " + msg);
            } else {
                if (resource.getType().equals(RancherDataType.CONTAINER) ||
                        resource.getType().equals(RancherDataType.CONTAINER_EVENT)) {
                    log.info("resourceId : " + resource.getId() + "\n" + "type : " + resource.getType() + "\n" + "state : " + resource.getState() + "\n" + "environmentId : " + resource.getAccountId());
                    if (resource.getId().equals(containerId)) {
                        if (checkStatus(resource)) {
                            session.close();
                        }
                    }
                }
            }

        }
    }

    public boolean checkStatus(RancherWSDataResource resource) {
        if (resource.getState().equals(RancherDataType.RUNNING)) return true;
        return false;
    }
}
