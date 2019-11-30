package com.projectlab.bme.ptl.rest.CompanyRestController;

import com.projectlab.bme.ptl.domain.company.Company;
import com.projectlab.bme.ptl.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import javax.validation.Valid;

@RestController
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public Iterable<Company> findAll(Pageable pageable){
        return companyService.findAll(pageable);
    }

    @PostMapping("/companies")
    public Company createCompany(@Valid @RequestBody Company theCompany){
        return companyService.saveCompany(theCompany);
    }


}
