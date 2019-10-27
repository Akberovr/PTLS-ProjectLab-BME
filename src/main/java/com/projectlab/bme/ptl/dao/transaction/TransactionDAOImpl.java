package com.projectlab.bme.ptl.dao.transaction;

import com.projectlab.bme.ptl.entity.Transaction;
import com.projectlab.bme.ptl.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {


    EntityManager entityManager;

    public TransactionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Transaction> findAll() {
        Session currentSession  = entityManager.unwrap(Session.class);


        Query<Transaction> theQuery = currentSession.createQuery("from Transaction", Transaction.class);

        List<Transaction> transactions = theQuery.getResultList();

        return transactions;
    }

    @Override
    public Transaction findById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //get the atm

        Transaction theTransaction = currentSession.get(Transaction.class, theId);

        //return the atm
        return theTransaction;
    }

    @Override
    public void save(Transaction theTransaction) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //save the atm

        currentSession.saveOrUpdate(theTransaction);
    }

    @Override
    public void deleteById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key

        Query theQuery =
                currentSession.createQuery("delete from Transaction where transaction_id=:transactionId");

        theQuery.setParameter("transactionId", theId);

        theQuery.executeUpdate();
    }
}
