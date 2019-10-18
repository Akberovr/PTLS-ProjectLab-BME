package com.projectlab.bme.ptl.service;

import com.projectlab.bme.ptl.entity.Employee;
import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

}
