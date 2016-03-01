package com.dzaen.testtask.websocket;

import com.dzaen.testtask.websocket.db.ejb.AccountManager;
import com.dzaen.testtask.websocket.db.model.Account;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MessageEncoder implements Encoder.Text<Message> {

	@Inject
	AccountManager ejb;

	List<Account> accountList;

	@Override
	public String encode(Message message) throws EncodeException {

		JsonObject data = message.getData();

		//generate token by UID
        final UUID uuid = UUID.randomUUID();


		if (data.getString("email").equals("fpi@bk.ru")
				&& data.getString("password").equals("123123") ) {

			accountList = ejb.queryCache();
			Account acc = new Account();

			//Save token to Mongo
			acc.setKey(uuid.toString());
			acc.setValue("fpi@bk.ru");

			ejb.save(acc);
			accountList.add(acc);


           //Keep alive token at 24 hours
			Date time = Calendar.getInstance().getTime();
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);
			cal.add(Calendar.HOUR, 24);
			String expTime = df.format(cal.getTime());

			String api_token = ejb.getOne(data.getString("email"));


			JsonObject jsonObject = Json.createObjectBuilder()
					.add("type", "CUSTOMER_API_TOKEN")
					.add("sequence_id", message.getSequence_id())
					.add("data", Json.createObjectBuilder()
							.add("api_token", api_token)
							.add("api_token_expiration_date", expTime)
							.build())
					.build();

			return jsonObject.toString();
		}


		//If Login Failure
       else {
			JsonObject jsonObject = Json.createObjectBuilder()
					.add("type", "CUSTOMER_ERROR")
					.add("sequence_id", message.getSequence_id())
					.add("data", Json.createObjectBuilder()
							.add("error_description", "Customer not found")
							.add("error_code", "customer.notFound")
							.build())
					.build();

			return jsonObject.toString();
		}


	}

	@Override
	public void init(EndpointConfig ec) {
		//System.out.println("MessageEncoder - init method called");
	}

	@Override
	public void destroy() {
		//System.out.println("MessageEncoder - destroy method called");
	}

}
