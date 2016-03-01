package com.dzaen.testtask.websocket;

import javax.json.JsonObject;

public class Message {

	private String subject;
	private String content;

	private String email;
	private String password;

	private String type;
	private String sequence_id;

	private JsonObject data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSequence_id() {
		return sequence_id;
	}

	public void setSequence_id(String sequence_id) {
		this.sequence_id = sequence_id;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JsonObject getData() {
		return data;
	}

	public void setData(JsonObject data) {
		this.data = data;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
