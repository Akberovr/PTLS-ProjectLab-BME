package com.projectlab.bme.ptl.repository;

import com.projectlab.bme.ptl.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
