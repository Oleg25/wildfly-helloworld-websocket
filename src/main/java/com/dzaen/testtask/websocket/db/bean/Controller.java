package com.dzaen.testtask.websocket.db.bean;


import com.dzaen.testtask.websocket.db.ejb.AccountManager;
import com.dzaen.testtask.websocket.db.model.Account;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Controller {

    @Inject
    AccountManager ejb;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    List<Account> accountList;

    private String key;
    private String value;

    @PostConstruct
    public void readDB() {
        accountList = ejb.queryCache();

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
        Account p = new Account();
        p.setKey(key);
        p.setValue(value);
        ejb.save(p);
        accountList.add(p);
        key="";
        value="";
    }

}
