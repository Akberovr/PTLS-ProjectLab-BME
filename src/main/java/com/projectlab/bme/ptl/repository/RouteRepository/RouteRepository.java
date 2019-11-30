package com.projectlab.bme.ptl.repository.RouteRepository;

import com.projectlab.bme.ptl.domain.company.Company;
import com.projectlab.bme.ptl.domain.route.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {



    Page<Route> findByCompanyId(int companyId, Pageable pageable);

    Optional<Route> findByRouteIdAndCompany(int id, Integer companyId);

}
