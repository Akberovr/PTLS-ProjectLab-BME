package com.projectlab.bme.ptl.service.company;


import com.projectlab.bme.ptl.domain.company.Company;
import com.projectlab.bme.ptl.repository.CompanyRepository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company theCompany){
       return companyRepository.save(theCompany);
    }

    public Iterable<Company> findAll(Pageable pageable){
        return companyRepository.findAll(pageable);
    }

    public Optional<Company> findCompanyById(Integer id){
        return companyRepository.findById(id);
    }

    public void delete(Integer id){
        companyRepository.deleteById(id);
    }

}
