package com.projectlab.bme.ptl.rest.TruckRestController;

import com.projectlab.bme.ptl.service.truck.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projectlab.bme.ptl.domain.truck.Truck;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class TruckRestController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/company/{truckId}/trucks")
    public Page<Truck> getAllTrucksByCompanyId(@PathVariable(value = "truckId") Integer truckId,
                                               Pageable pageable) {
        return truckService.getAllTrucksByCompanyId(truckId, pageable);

    }

    @PostMapping("/company/{truckId}/trucks")
    public Truck createRoute(@PathVariable(value = "truckId") Integer companyId,
                             @Valid @RequestBody Truck truck) {
        return truckService.saveTruck(companyId, truck);
    }


    @PutMapping("/company/{truckId}/trucks/{truckId}")
    public Truck updateTruck(@PathVariable(value = "truckId") Integer companyId
            , @PathVariable(value = "truckId") Integer truckId
            , @Valid @RequestBody Truck theTruck) {

        return truckService.updateTruck(companyId, truckId, theTruck);

    }

    @DeleteMapping("/companies/{companyId}/trucks/{truckId}")
    public ResponseEntity<?> deleteRoute(@PathVariable(value = "companyId") Integer companyId,
                                         @PathVariable(value = "truckId") Integer truckId) {

        truckService.delete(companyId, truckId);
        return ResponseEntity.ok().build();
    }

}
