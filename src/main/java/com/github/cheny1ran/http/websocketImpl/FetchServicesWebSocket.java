package com.github.cheny1ran.http.websocketImpl;

import com.alibaba.fastjson.JSON;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.dataobject.RancherWSObject;
import com.github.cheny1ran.http.RancherWebSocket;
import com.github.cheny1ran.model.Stack;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.List;

/**
 * 功能描述:
 *  websocket to fetch service id list after create a new stack
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
            Stack resource = JSON.parseObject(dataResource, Stack.class);

            log.info("Got stack change info " + resource.toString());
            List<String> serviceIds = resource.getServiceIds();
            if (serviceIds != null && !serviceIds.isEmpty()) {
                log.info("Fetched service id : " + JSON.toJSONString(serviceIds) + " quit.");
                this.session.close();
            }
        }

    }
}
