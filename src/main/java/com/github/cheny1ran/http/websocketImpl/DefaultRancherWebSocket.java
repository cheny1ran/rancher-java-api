package com.github.cheny1ran.http.websocketImpl;

import com.alibaba.fastjson.JSON;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.dataobject.RancherWSDataResource;
import com.github.cheny1ran.dataobject.RancherWSObject;
import com.github.cheny1ran.http.RancherWebSocket;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * 功能描述:
 * default websocket doing nothing just print "recource.change" type message.
 *
 * @Author chen.yiran
 * @Date 17/3/14.
 */

@WebSocket
public class DefaultRancherWebSocket extends RancherWebSocket {

    private final static Logger log = Logger.getLogger(DefaultRancherWebSocket.class);

    @Override
    public void onMessage(String msg) {
        RancherWSObject rancherObject = JSON.parseObject(msg, RancherWSObject.class);
        if (rancherObject.getName().equals(RancherDataType.RESOURCE_CHANGE_EVENT)) {

            String resourceStr = rancherObject.getData().get(RancherDataType.RESOURCE).toString();
            RancherWSDataResource resource = JSON.parseObject(resourceStr, RancherWSDataResource.class);

            log.info(resource.toString());
        }
    }
}
