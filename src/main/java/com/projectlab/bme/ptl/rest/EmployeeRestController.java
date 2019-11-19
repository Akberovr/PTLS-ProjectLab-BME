package com.projectlab.bme.ptl.rest;


import com.projectlab.bme.ptl.entity.Employee;
import com.projectlab.bme.ptl.models.AuthenticationRequest;
import com.projectlab.bme.ptl.models.AuthenticationResponse;
import com.projectlab.bme.ptl.repositories.EmployeeRepository;
import com.projectlab.bme.ptl.service.MyUserDetailsService;
import com.projectlab.bme.ptl.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/authenticated")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getUsername())
           );
       }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password");
       }

       final UserDetails userDetails = userDetailsService
               .loadUserByUsername(authenticationRequest.getUsername());

       final String jwt = jwtTokenUtil.generateToken(userDetails);

       return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return empRepo.findAll();
    }


    //add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getDriver(@PathVariable int employeeId){

        Optional<Employee> theEmployee = empRepo.findById(employeeId);

        if (!theEmployee.isPresent()){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        return theEmployee.get();

    }


    @PostMapping("/employees")
    public ResponseEntity<Employee> addDriver(@RequestBody Employee theEmployee){
        Employee savedEmployee = empRepo.save(theEmployee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeId}").
                buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateDriver(@RequestBody Employee theEmployee, @PathVariable int id){

        Optional<Employee> employeeOptional = empRepo.findById(id);

        if (!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        theEmployee.setId(id);

        empRepo.save(theEmployee);

        return ResponseEntity.noContent().build();

    }


    @DeleteMapping("/employee/{employeeId}")
    public String deleteDriver(@PathVariable int employeeId){

        Employee tempEmployee = empRepo.findById(employeeId).orElse(null);

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        empRepo.deleteById(employeeId);

        return "Deleted Employee id- "+ employeeId;
    }

}

