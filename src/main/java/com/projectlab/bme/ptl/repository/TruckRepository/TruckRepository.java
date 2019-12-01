package com.projectlab.bme.ptl.repository.TruckRepository;

import com.projectlab.bme.ptl.domain.truck.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Integer> {
}
