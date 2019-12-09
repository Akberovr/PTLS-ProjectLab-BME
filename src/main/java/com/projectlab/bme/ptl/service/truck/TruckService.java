package com.projectlab.bme.ptl.service.truck;

import com.projectlab.bme.ptl.exception.ResourceNotFoundException;
import com.projectlab.bme.ptl.repository.CompanyRepository.CompanyRepository;
import com.projectlab.bme.ptl.repository.TruckRepository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.projectlab.bme.ptl.domain.truck.Truck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Page<Truck> getAllTrucksByCompanyId(Integer companyId, Pageable pageable) {
        return truckRepository.findByCompanyId(companyId, pageable);
    }

    public Truck saveTruck(Integer companyId, Truck theTruck) {

        return companyRepository.findById(companyId).map(company -> {
            theTruck.setCompany(company);
            return truckRepository.save(theTruck);
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyID" + companyId + " not found"));
    }

    public Truck updateTruck(int companyId, int truckId, Truck theTruck) {
        if (!companyRepository.existsById(companyId)) {
            throw new ResourceNotFoundException("CompanyId " + companyId + " not found");
        }

        return truckRepository.findById(truckId).map(route -> {
            route.setTruck_brand(theTruck.getTruck_brand());
            return truckRepository.save(route);
        }).orElseThrow(() -> new ResourceNotFoundException("TruckId " + truckId + "not found"));
    }

    public Iterable<Truck> findAll() {
        return truckRepository.findAll();
    }

    public Optional<Truck> findRouteById(Integer id) {
        return truckRepository.findById(id);
    }


    public void delete(Integer companyId, Integer truckId) {
        truckRepository.findByIdAndCompanyId(truckId, companyId).map(route -> {
            truckRepository.delete(route);
            return "Deleted truck id- " + truckId;
        }).orElseThrow(() -> new ResourceNotFoundException("Truck not found with id " + truckId + " and companyId " + companyId));
    }


}
