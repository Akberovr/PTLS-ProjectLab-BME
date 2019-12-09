package com.projectlab.bme.ptl.repository.TruckRepository;

import com.projectlab.bme.ptl.domain.route.Route;
import com.projectlab.bme.ptl.domain.truck.Truck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TruckRepository extends JpaRepository<Truck, Integer> {

    Page<Truck> findByCompanyId(int companyId, Pageable pageable);

    Optional<Truck> findByIdAndCompanyId(int id, Integer companyId);

}
