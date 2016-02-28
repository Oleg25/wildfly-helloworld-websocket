package com.dzaen.testtask.websocket.model;

import com.dzaen.testtask.websocket.model.Login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AuthManager {

    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;

    /*
     public void delete(){
     Query query = em.createQuery("DELETE FROM Property p");

     query.executeUpdate();
     em.flush();
     }
     */

    public void save(Login p) {
        em.persist(p);

    }

    public List<Login> queryCache() {
        Query query = em.createQuery("FROM Login p");

        List<Login> list = query.getResultList();
        return list;
    }

}
