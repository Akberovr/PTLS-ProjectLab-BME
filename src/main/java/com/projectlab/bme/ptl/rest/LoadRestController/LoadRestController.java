package com.projectlab.bme.ptl.rest.LoadRestController;


import com.projectlab.bme.ptl.domain.load.Load;
import com.projectlab.bme.ptl.service.load.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class LoadRestController {


    @Autowired
    private LoadService loadService;

    @GetMapping("/truck/{truckId}/loads")
    public Page<Load> getAllRoutesByCompanyId(@PathVariable(value = "truckId") Integer truckId,
                                              Pageable pageable) {
        return loadService.getAllLoadsByTruckId(truckId, pageable);

    }

    @PostMapping("/truck/{truckId}/loads")
    public Load createRoute(@PathVariable(value = "truckId") Integer truckId,
                            @Valid @RequestBody Load load) {
        return loadService.saveLoad(truckId, load);
    }


    @PutMapping("/truck/{truckId}/loads/{loadId}")
    public Load updateLoad(@PathVariable(value = "truckId") Integer truckId
            , @PathVariable(value = "loadId") Integer loadId
            , @Valid @RequestBody Load theLoad) {

        return loadService.updateLoad(truckId, loadId, theLoad);

    }

    @DeleteMapping("/truck/{truckId}/loads/{loadId}")
    public ResponseEntity<?> deleteLoad(@PathVariable(value = "truckId") Integer truckId,
                                        @PathVariable(value = "loadId") Integer loadId) {

        loadService.delete(truckId, loadId);
        return ResponseEntity.ok().build();
    }

}
