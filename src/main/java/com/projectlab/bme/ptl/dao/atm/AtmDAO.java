package com.projectlab.bme.ptl.dao.atm;

import java.util.List;
import com.projectlab.bme.ptl.entity.Atm;

public interface AtmDAO {

    public List<Atm> findAll();

    public Atm findById(int theId);

    public void save(Atm theAtm);

    public void deleteById(int theId);

}
