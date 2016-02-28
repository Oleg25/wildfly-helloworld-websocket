package com.dzaen.testtask.websocket.encoders;



import com.dzaen.testtask.websocket.messages.AuthMessage;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.StringWriter;

public class MessageEncoder implements Encoder.Text<AuthMessage> {
	
	@Override
	public void init(EndpointConfig ec) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public String encode(AuthMessage betMsg) throws EncodeException {
		StringWriter swriter = new StringWriter();
		try (JsonWriter jsonWrite = Json.createWriter(swriter)) {
			JsonObjectBuilder builder = Json.createObjectBuilder();
			builder.add("sequence_ID",
					betMsg.getSequence_ID()).add("TYPE_MESSAGE", betMsg.getTYPE_MESSAGE())
			.add("data", betMsg.getData());
			jsonWrite.writeObject(builder.build());
		}
		return swriter.toString();
	}
}
