package com.projectlab.bme.ptl.service.week;

import com.projectlab.bme.ptl.entity.Week;

import java.util.List;

public interface WeekService {

    public List<Week> findAll();

    public Week findById(int theId);

    public void save(Week theWeek);

    public void deleteById(int theId);

}
