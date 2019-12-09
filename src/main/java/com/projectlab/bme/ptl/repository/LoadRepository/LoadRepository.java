package com.projectlab.bme.ptl.repository.LoadRepository;


import com.projectlab.bme.ptl.domain.load.Load;
import com.projectlab.bme.ptl.domain.route.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {

    Page<Load> findByTruckId(int truckId, Pageable pageable);

    Optional<Load> findByIdAndTruckId(int id, int truckId);


}
