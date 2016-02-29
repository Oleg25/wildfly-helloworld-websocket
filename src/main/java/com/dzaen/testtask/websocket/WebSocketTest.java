package com.dzaen.testtask.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/ws", encoders = { MessageEncoder.class }, decoders = { MessageDecoder.class })
public class WebSocketTest {

	@OnMessage
	public void onMessage(Message message, Session session) throws IOException,
			EncodeException {

		// Echo the received message back to the client
		Message response = new Message();
		response.setSubject("Response to " + message.getSubject());
		response.setContent("echo " + message.getContent());
		session.getBasicRemote().sendObject(response);

	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected");
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}

}
