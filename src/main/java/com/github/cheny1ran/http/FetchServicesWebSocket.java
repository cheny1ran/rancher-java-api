package com.github.cheny1ran.http;

import com.alibaba.fastjson.JSON;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.dataobject.RancherWSObject;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * 功能描述:
 *  用于获取 stack 下的 service id
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */

@WebSocket
public class FetchServicesWebSocket extends RancherWebSocket {

    private final static Logger log = Logger.getLogger(FetchServicesWebSocket.class);

    private final String stackId;

    public FetchServicesWebSocket(String stackId) {
        this.stackId = stackId;
    }

    @Override
    public void onMessage(String msg) {
        RancherWSObject rancherWSObject = JSON.parseObject(msg, RancherWSObject.class);

        if (rancherWSObject.getName().equals(RancherDataType.RESOURCE_CHANGE_EVENT) &&
                rancherWSObject.getResourceType().equals(RancherDataType.STACK) &&
                rancherWSObject.getResourceId().equals(stackId)) {

            String dataResource = rancherWSObject.getData().get(RancherDataType.RESOURCE).toString();
//            StackDataResource resource = JSON.parseObject(dataResource, StackDataResource.class);
//
//            log.info("Got stack change info " + resource.toString());
//            List<String> serviceIds = resource.getServiceIds();
//            if (serviceIds != null && serviceIds.size() > 0) {
//                log.info("Fetched service id : "+serviceIds.get(0)+" quit.");
//                this.session.close();
//            }
        }

    }
}
