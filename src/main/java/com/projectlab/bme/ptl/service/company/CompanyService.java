package com.projectlab.bme.ptl.service.company;


import com.projectlab.bme.ptl.domain.company.Company;
import com.projectlab.bme.ptl.exception.ResourceNotFoundException;
import com.projectlab.bme.ptl.repository.CompanyRepository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company theCompany) {
        return companyRepository.save(theCompany);
    }

    public Iterable<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Company updateCompany(int companyId, Company theCompany) {

        if (!companyRepository.existsById(companyId)) {
            throw new ResourceNotFoundException("CompanyId " + companyId + " not found");
        }

        return companyRepository.findById(companyId).map(company -> {
            company.setFirst_name(theCompany.getFirst_name());
            company.setLast_name(theCompany.getLast_name());
            company.setEmail(theCompany.getEmail());
            return companyRepository.save(company);
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyId " + companyId + " not found"));

    }

    public Optional<Company> findCompanyById(Integer id) {
        return companyRepository.findById(id);
    }

    public void delete(Integer id) {

        companyRepository.findById(id).map(company -> {
            companyRepository.delete(company);
            return "Deleted company id- " + id;
        }).orElseThrow(() -> new ResourceNotFoundException("Company not found companyId " + id));

    }

}
