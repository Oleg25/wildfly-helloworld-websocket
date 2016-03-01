package com.dzaen.testtask.websocket.db.ejb;



import com.dzaen.testtask.websocket.db.model.Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AccountManager {

    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;

    /*
     public void delete(){
     Query query = em.createQuery("DELETE FROM Account acc");

     query.executeUpdate();
     em.flush();
     }
     */

    public String getOne(String email) {

        Query query = em.createQuery("select acc.value from Account acc where key = :email ");
        query.setParameter("email", email);

        String result = (String) query.getSingleResult();

       return result;

    }

    public void save(Account p) {
        em.persist(p);

    }

    public List<Account> queryCache() {
        Query query = em.createQuery("FROM Account acc");

        List<Account> list = query.getResultList();
        return list;
    }

}
