package com.dzaen.testtask.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@ServerEndpoint(value = "/ws", encoders = { MessageEncoder.class }, decoders = { MessageDecoder.class })
public class EndpointAuth {

	private Logger logger = Logger.getLogger(getClass().getName());
	private static Set<Object> clients = Collections.synchronizedSet(new HashSet<>());

	@OnMessage
	public void onMessage(Message message, Session session) throws IOException,
			EncodeException {

		// Echo the received message back to the client
		Message response = new Message();

		 response.setType(message.getType());
		 response.setSequence_id(message.getSequence_id());
		 response.setData(message.getData());

		session.getBasicRemote().sendObject(response);

	}

	@OnOpen
	public void onOpen(Session session) {
		clients.add(session);

	}

	@OnClose
	public void onClose(Session session) {
		logger.info("Websoket session closed: " + session.getId());
		clients.remove(session);
	}


	@OnError
	public void error(Session session, Throwable t) {
		t.printStackTrace();
	}

}
