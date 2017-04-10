package com.github.cheny1ran.http;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/13.
 */
public class WebSocketComponent {

    private final String accessKey;

    private final String secretKey;

    private String wsUrl;

    private volatile boolean stop;

    private final static String DEFAULT_EVENT = "resource.change";

    public void stop() {
        this.stop = true;
    }

    public WebSocketComponent(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.stop = false;
        this.wsUrl = "ws://%s/v2-beta/projects/%s/subscribe?eventNames=%s";
    }

    public void init(String url, String projectId, String eventNames) {
        wsUrl = String.format(wsUrl, url, projectId, eventNames);
    }

    public void init(String url, String projectId) {
        // TODO: 17/3/14 数据校验
        wsUrl = String.format(wsUrl, url, projectId, DEFAULT_EVENT);
    }

    public void listen() throws Exception {
        listen(null);
    }

    public void listen(String containerId) throws Exception {
        WebSocketClient client = new WebSocketClient();
        RancherWebSocket socket = new DefaultRancherWebSocket(containerId);

        URI uri = new URI(wsUrl);
        client.start();
        ClientUpgradeRequest request = new ClientUpgradeRequest();
        request.setHeader("Authorization", generateAuth());
        Future<Session> session = client.connect(socket, uri, request);
        System.out.println("connect to " + wsUrl);

        socket.awaitClose(600, TimeUnit.SECONDS);
    }


    public String generateAuth() {
        String userpass = accessKey + ":" + secretKey;
        String authorization = "Basic " + new String(new Base64().encode(userpass.getBytes())).trim();
        return authorization;
    }
}
