package com.projectlab.bme.ptl.dao;

import java.util.List;

import com.projectlab.bme.ptl.entity.Employee;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteByid(int theId);


}
