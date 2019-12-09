package com.projectlab.bme.ptl.service.load;

import com.projectlab.bme.ptl.exception.ResourceNotFoundException;
import com.projectlab.bme.ptl.repository.LoadRepository.LoadRepository;
import com.projectlab.bme.ptl.repository.TruckRepository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projectlab.bme.ptl.domain.load.Load;

import java.util.Optional;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Autowired
    private TruckRepository truckRepository;


    public Page<Load> getAllLoadsByTruckId(Integer truckId, Pageable pageable) {
        return loadRepository.findByTruckId(truckId, pageable);
    }


    public Load saveLoad(Integer truckId, Load theLoad) {

        return truckRepository.findById(truckId).map(truck -> {
            theLoad.setTruck(truck);
            return loadRepository.save(theLoad);
        }).orElseThrow(() -> new ResourceNotFoundException("TruckID" + truckId + " not found"));
    }

    public Load updateLoad(int truckId, int loadId, Load theLoad) {
        if (!truckRepository.existsById(truckId)) {
            throw new ResourceNotFoundException("TruckID " + truckId + " not found");
        }

        return loadRepository.findById(loadId).map(route -> {
            route.setLoad_price(theLoad.getLoad_price());
            return loadRepository.save(route);
        }).orElseThrow(() -> new ResourceNotFoundException("LoadID " + loadId + "not found"));
    }


    public Iterable<Load> findAll() {
        return loadRepository.findAll();
    }

    public Optional<Load> findLoadById(Integer id) {
        return loadRepository.findById(id);
    }


    public void delete(Integer truckId, Integer loadId) {
        loadRepository.findByIdAndTruckId(loadId, truckId).map(route -> {
            loadRepository.delete(route);
            return "Deleted load id- " + loadId;
        }).orElseThrow(() -> new ResourceNotFoundException("Load not found with id " + loadId + " and truckId " + truckId));
    }


}
