package com.dzaen.testtask.websocket;


import com.dzaen.testtask.websocket.db.ejb.AccountManager;
import com.dzaen.testtask.websocket.db.model.Account;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.List;

public class MessageDecoder implements Decoder.Text<Message> {



	@Override
	public Message decode(String jsonMessage) throws DecodeException {

		JsonObject jsonObject = Json
				.createReader(new StringReader(jsonMessage)).readObject();
		Message message = new Message();


		message.setType(jsonObject.getString("type"));
		message.setSequence_id(jsonObject.getString("sequence_id"));
        message.setData(jsonObject.getJsonObject("data"));

		JsonObject data = message.getData();

		message.setEmail(data.getString("email"));
		message.setPassword(data.getString("password"));

		return message;

	}




	@Override
	public boolean willDecode(String jsonMessage) {
		try {

			Json.createReader(new StringReader(jsonMessage)).readObject();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void init(EndpointConfig ec) {

	}

	@Override
	public void destroy() {
		//System.out.println("MessageDecoder - destroy method called");
	}

}
