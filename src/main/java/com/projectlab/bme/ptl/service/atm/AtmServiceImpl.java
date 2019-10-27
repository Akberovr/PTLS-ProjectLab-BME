package com.projectlab.bme.ptl.service.atm;


import com.projectlab.bme.ptl.dao.atm.AtmDAO;
import com.projectlab.bme.ptl.entity.Atm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtmServiceImpl implements AtmService{

    AtmDAO atmDAO;
    @Autowired
    public AtmServiceImpl(AtmDAO atmDAO) {
        this.atmDAO = atmDAO;
    }

    @Override
    @Transactional
    public List<Atm> findAll() {
        return atmDAO.findAll();
    }

    @Override
    @Transactional
    public Atm findById(int theId) {
        return atmDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Atm theAtm) {
        atmDAO.save(theAtm);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        atmDAO.deleteById(theId);
    }
}
