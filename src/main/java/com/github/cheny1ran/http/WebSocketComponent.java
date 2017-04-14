package com.github.cheny1ran.http;

import com.github.cheny1ran.RancherAPI;
import com.github.cheny1ran.constant.RancherDataType;
import com.github.cheny1ran.http.websocketImpl.DefaultRancherWebSocket;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * websocket entry
 *
 * @Author chen.yiran
 * @Date 17/3/13.
 */

@SuppressWarnings("unused")
public class WebSocketComponent {

    private final RancherAPI API;

    private final RancherWebSocket webSocket;

    private String wsUrl;

    public WebSocketComponent(RancherAPI api, RancherWebSocket webSocket, String eventName) {
        this.API = api;
        this.webSocket = webSocket;
        this.wsUrl = "ws://%s/v2-beta/projects/%s/subscribe?eventNames=%s";
        wsUrl = String.format(wsUrl, api.getUrl(), api.getProjectId(), eventName);
    }

    public WebSocketComponent(RancherAPI api, RancherWebSocket webSocket) {
        this(api, webSocket, RancherDataType.RESOURCE_CHANGE_EVENT);
    }

    public WebSocketComponent(RancherAPI api) {
        this(api, new DefaultRancherWebSocket());
    }

    public void listen(int duration) throws Exception {
        WebSocketClient client = new WebSocketClient();

        URI uri = new URI(wsUrl);
        client.start();
        ClientUpgradeRequest request = new ClientUpgradeRequest();
        request.setHeader("Authorization", API.getAuthorization());
        Future<Session> session = client.connect(webSocket, uri, request);
        System.out.println("Trying to connect to " + wsUrl);

        webSocket.awaitClose(duration, TimeUnit.SECONDS);
    }
}
