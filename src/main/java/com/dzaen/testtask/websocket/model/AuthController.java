package com.dzaen.testtask.websocket.model;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class AuthController {

    @Inject
    AuthManager ejb;

    public List<Login> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Login> propertyList) {
        this.propertyList = propertyList;
    }

    List<Login> propertyList;

    private String email;
    private String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @PostConstruct
    public void readDB() {
        propertyList = ejb.queryCache();

    }



    public void save() {
        Login p = new Login();
         p.setEmail(email);
         p.setPass(pass);
         ejb.save(p);
        propertyList.add(p);
          email="";
          pass="";
    }

}
