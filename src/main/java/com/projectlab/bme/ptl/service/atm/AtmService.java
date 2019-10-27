package com.projectlab.bme.ptl.service.atm;

import com.projectlab.bme.ptl.entity.Atm;

import java.util.List;

public interface AtmService {

    public List<Atm> findAll();

    public Atm findById(int theId);

    public void save(Atm theAtm);

    public void deleteById(int theId);
}
