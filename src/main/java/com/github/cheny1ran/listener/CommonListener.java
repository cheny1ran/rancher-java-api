package com.github.cheny1ran.listener;

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
 * @Date 17/3/14.
 */
@WebSocket
public class CommonListener {

    private final static Logger log= Logger.getLogger(CommonListener.class);

    private final CountDownLatch closeLatch;

    @SuppressWarnings("unused")
    private Session session;

    public CommonListener() {
        this.closeLatch = new CountDownLatch(1);
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.session = null;
        this.closeLatch.countDown(); // trigger latch
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        log.info("Got connect: %s%n" + session);
        System.out.printf("Got connect: %s%n", session);
        this.session = session;

    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        // TODO: 17/3/13
        System.out.printf("Got msg: %s%n", msg);
    }

}
