package com.projectlab.bme.ptl.rest;


import com.projectlab.bme.ptl.domain.Employee;
import com.projectlab.bme.ptl.model.AuthenticationRequest;
import com.projectlab.bme.ptl.model.AuthenticationResponse;
import com.projectlab.bme.ptl.service.EmployeeService;
//import com.projectlab.bme.ptl.service.MyUserDetailsService;
//import com.projectlab.bme.ptl.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ptl/api")
public class EmployeeRestController {


    @Autowired
    private EmployeeService employeeService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private MyUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//
//    @PostMapping(value = "/authenticated")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getUsername())
//            );
//        }catch (BadCredentialsException e){
//            throw new Exception("Incorrect username or password");
//        }
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//
//    }


    @GetMapping
    public Iterable<Employee> findAll() {
        return employeeService.findAll();
    }
//

    //add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getDriver(@PathVariable int employeeId) {

        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        if (!theEmployee.isPresent()) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee.get();

    }


    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee theEmployee, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Employee savedEmployee = employeeService.saveEmployee(theEmployee);

        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateDriver(@RequestBody Employee theEmployee, @PathVariable int id) {

        Optional<Employee> employeeOptional = employeeService.findById(id);

        if (!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        theEmployee.setId(id);

        Employee updatedEmployee = employeeService.saveEmployee(theEmployee);

        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteDriver(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId).orElse(null);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.delete(employeeId);

        return "Deleted Employee id- " + employeeId;
    }

}

