package com.projectlab.bme.ptl.dao.atm;

import com.projectlab.bme.ptl.entity.Atm;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AtmDAOHibernateImpl implements AtmDAO {


    //define field for EntityManager
    private EntityManager entityManager;


    @Autowired
    public AtmDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Atm> findAll() {
        Session currentSession  = entityManager.unwrap(Session.class);


        Query<Atm> theQuery = currentSession.createQuery("from Atm", Atm.class);

        List<Atm> atms = theQuery.getResultList();

        return atms;
    }

    @Override
    public Atm findById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //get the atm

        Atm theAtm = currentSession.get(Atm.class, theId);

        //return the atm
        return theAtm;
    }

    @Override
    public void save(Atm theAtm) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //save the atm

        currentSession.saveOrUpdate(theAtm);
    }

    @Override
    public void deleteById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key

        Query theQuery =
                currentSession.createQuery("delete from Atm where atm_id=:atmId");

        theQuery.setParameter("atmId", theId);

        theQuery.executeUpdate();
    }
}
