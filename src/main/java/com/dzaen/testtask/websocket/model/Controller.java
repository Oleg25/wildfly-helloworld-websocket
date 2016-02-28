package com.dzaen.testtask.websocket.model;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Controller {

    @Inject
    AuthManager ejb;

    public List<Login> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Login> propertyList) {
        this.propertyList = propertyList;
    }

    List<Login> propertyList;

    private String key;
    private String value;

    @PostConstruct
    public void readDB() {
        propertyList = ejb.queryCache();

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void save() {
        Login p = new Login();
        p.setKey(key);
        p.setValue(value);
        ejb.save(p);
        propertyList.add(p);
        key="";
        value="";
    }

}
