package com.projectlab.bme.ptl.service.route;

import com.projectlab.bme.ptl.exception.ResourceNotFoundException;
import com.projectlab.bme.ptl.repository.CompanyRepository.CompanyRepository;
import com.projectlab.bme.ptl.repository.RouteRepository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.projectlab.bme.ptl.domain.route.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Page<Route> getAllRoutesByCompanyId(Integer companyId, Pageable pageable){
            return routeRepository.findByCompany(companyId,pageable);
    }

    public Route saveRoute(Integer companyId,Route theRoute){

        return companyRepository.findById(companyId).map(company -> {
            theRoute.setCompany(company);
            return routeRepository.save(theRoute);
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyID" + companyId + " not found"));
    }

    public Route updateRoute(Integer companyId, Integer routeId, Route theRoute){
        if (!companyRepository.existsById(companyId)){
            throw new ResourceNotFoundException("CompanyId " + companyId + " not found");
        }

        return routeRepository.findById(routeId).map(route -> {
            route.setRoute_destination(theRoute.getRoute_destination());
            route.setRoute_start(theRoute.getRoute_start());
            return routeRepository.save(theRoute);
        }).orElseThrow(() -> new ResourceNotFoundException("RouteId "+ routeId + "not found"));
    }

    public Iterable<Route> findAll(){
        return routeRepository.findAll();
    }

    public Optional<Route> findRouteById(Integer id){
        return routeRepository.findById(id);
    }

    public void delete(Integer companyId, Integer routeId) {
        routeRepository.findByRouteIdAndCompany(routeId,companyId).map(route -> {
           routeRepository.delete(route);
           return "Deleted route id- "+ routeId;
       }).orElseThrow(() -> new ResourceNotFoundException("Route not found with id " + routeId + " and companyId " + companyId));
    }

}
