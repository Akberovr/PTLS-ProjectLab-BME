package com.projectlab.bme.ptl.service.truck;

import com.projectlab.bme.ptl.repository.TruckRepository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.projectlab.bme.ptl.domain.truck.Truck;

import java.util.Optional;

public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

    public Truck saveDriver(Truck theDriver){
        return truckRepository.save(theDriver);
    }

    public Iterable<Truck> findAll(){
        return truckRepository.findAll();
    }

    public Optional<Truck> findDriverById(Integer id){
        return truckRepository.findById(id);
    }

    public void delete(Integer id) {
        truckRepository.deleteById(id);
    }



}
