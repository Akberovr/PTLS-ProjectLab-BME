package com.projectlab.bme.ptl.rest;


import com.projectlab.bme.ptl.dao.EmployeeDAO;
import com.projectlab.bme.ptl.service.EmployeeService;
import com.projectlab.bme.ptl.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    //add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        return theEmployee;

    }


    @PostMapping("/employees/{employeeid}")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);

        return theEmployee;
    }


    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee id- "+ employeeId;
    }

}

