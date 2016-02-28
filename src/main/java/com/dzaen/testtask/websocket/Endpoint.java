package com.dzaen.testtask.websocket;

/**
 * Created by velmi on 28.02.2016.
 */

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/auth")
public class Endpoint {

    @OnMessage
    public void login(String text, Session client) {

        client.getAsyncRemote().sendText(text.toUpperCase());
    }
}
