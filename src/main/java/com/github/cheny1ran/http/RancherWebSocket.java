package com.github.cheny1ran.http;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/13.
 */

@WebSocket
public abstract class RancherWebSocket {

    private static final Logger log = Logger.getLogger(RancherWebSocket.class);

    private final CountDownLatch closeLatch;

    @SuppressWarnings("unused")
    protected Session session;

    public RancherWebSocket() {
        this.closeLatch = new CountDownLatch(1);
    }

    public RancherWebSocket(CountDownLatch closeLatch) {
        this.closeLatch = closeLatch;
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        log.info(String.format("Connection closed: %d - %s%n", statusCode, reason));
        this.session = null;
        this.closeLatch.countDown(); // trigger latch
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        log.info("Got connect:" + session);
        this.session = session;

    }

    @OnWebSocketMessage
    public abstract void onMessage(String msg);

}
