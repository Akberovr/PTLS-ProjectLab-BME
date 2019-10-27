package com.projectlab.bme.ptl.dao.week;

import com.projectlab.bme.ptl.entity.Week;

import java.util.List;

public interface WeekDAO {


    public List<Week> findAll();

    public Week findById(int theId);

    public void save(Week theAtm);

    public void deleteById(int theId);


}
