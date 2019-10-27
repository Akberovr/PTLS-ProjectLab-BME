package com.projectlab.bme.ptl.dao.week;

import com.projectlab.bme.ptl.entity.Week;
import com.projectlab.bme.ptl.entity.Week;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class WeekDAOImpl implements WeekDAO {

    //define field for EntityManager
    private EntityManager entityManager;

    public WeekDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Week> findAll() {
        Session currentSession  = entityManager.unwrap(Session.class);


        Query<Week> theQuery = currentSession.createQuery("from Week", Week.class);

        List<Week> weeks = theQuery.getResultList();

        return weeks;
    }

    @Override
    public Week findById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //get the week

        Week theWeek = currentSession.get(Week.class, theId);

        //return the week
        return theWeek;
    }

    @Override
    public void save(Week theWeek) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //save the week

        currentSession.saveOrUpdate(theWeek);
    }

    @Override
    public void deleteById(int theId) {
        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key

        Query theQuery =
                currentSession.createQuery("delete from Week where week_id=:weekId");

        theQuery.setParameter("weekId", theId);

        theQuery.executeUpdate();
    }
}
