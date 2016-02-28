package com.dzaen.testtask.websocket;

/**
 * Created by velmi on 28.02.2016.
 */

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@ServerEndpoint("/auth")
public class Endpoint {


    private Logger logger = Logger.getLogger(getClass().getName());
    private static Set<Object> clients = Collections.synchronizedSet(new HashSet<>());


    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);

    }

    @OnMessage
    public void login(String text, Session client) {

        client.getAsyncRemote().sendText(text.toUpperCase());
    }

    // remove the session after it's closed
    @OnClose
    public void onClose(Session session) {
        logger.info("Websoket session closed: " + session.getId());
        clients.remove(session);
    }

    // Exception handling
    @OnError
    public void error(Session session, Throwable t) {
        t.printStackTrace();
    }
}
