package com.projectlab.bme.ptl.dao.address;

import com.projectlab.bme.ptl.entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO{


    //define field for EntityManager
    private EntityManager entityManager;


    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Address> findAll() {
        Session currentSession  = entityManager.unwrap(Session.class);


        Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);

        List<Address> addresses = theQuery.getResultList();

        return addresses;
    }

    @Override
    public Address findById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //get the atm

        Address theAddress = currentSession.get(Address.class, theId);

        //return the atm
        return theAddress;
    }

    @Override
    public void save(Address theAddress) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //save the atm

        currentSession.saveOrUpdate(theAddress);
    }

    @Override
    public void deleteById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key

        Query theQuery =
                currentSession.createQuery("delete from Address where address_id=:addressId");

        theQuery.setParameter("addressId", theId);

        theQuery.executeUpdate();
    }

}
