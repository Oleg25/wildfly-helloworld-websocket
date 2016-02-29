package com.dzaen.testtask.websocket.model;

/**
 * Created by velmi on 28.02.2016.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class Login {

    UUID uuid = UUID.randomUUID();
    String randomUUIDString = uuid.toString();

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String email;
    private String pass;
    private String session_token;

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    private String api_token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSession_token() {
        return session_token;
    }

    public void setSession_token(String session_token) {

        //session_token = randomUUIDString;
        this.session_token = session_token;
    }




}
