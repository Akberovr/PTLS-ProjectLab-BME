package com.projectlab.bme.ptl.rest.RouteRestController;

import com.projectlab.bme.ptl.service.route.RouteService;
import org.springframework.data.domain.Page;
import com.projectlab.bme.ptl.domain.route.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RouteRestController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/company/{companyId}/routes")
    public Page<Route> getAllRoutesByCompanyId(@PathVariable (value = "companyId") Integer companyId,
                                               Pageable pageable){
        return routeService.getAllRoutesByCompanyId(companyId,pageable);

    }

    @PostMapping("/company/{companyId}/routes")
    public Route createRoute(@PathVariable (value = "companyId") Integer companyId,
                             @Valid @RequestBody Route route){
        return routeService.saveRoute(companyId,route);
    }

    @PutMapping("/company/{companyId}/routes/{routeId}")
    public Route updateRoute(@PathVariable (value = "companyId") Integer companyId
    ,@PathVariable(value = "routeId") Integer routeId
    ,@Valid @RequestBody Route theRoute){

        return routeService.updateRoute(companyId,routeId,theRoute);

    }

    @DeleteMapping("/companies/{companyId}/routes/{routeId}")
    public ResponseEntity<?> deleteRoute(@PathVariable (value = "companyId") Integer companyId,
                                         @PathVariable (value = "routeId") Integer routeId){

        routeService.delete(companyId,routeId);
        return ResponseEntity.ok().build();
    }

}
