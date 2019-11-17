package com.projectlab.bme.ptl.repositories;

import com.projectlab.bme.ptl.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
