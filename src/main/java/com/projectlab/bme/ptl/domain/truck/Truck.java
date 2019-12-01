package com.projectlab.bme.ptl.domain.truck;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "truck")
public class Truck {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int truckId;

    private @NotBlank(message = "Field can not be blank") String truck_brand;

    public Truck() {

    }

    public Truck(@NotBlank(message = "Field can not be blank") String truck_brand) {
        this.truck_brand = truck_brand;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public String getTruck_brand() {
        return truck_brand;
    }

    public void setTruck_brand(String truck_brand) {
        this.truck_brand = truck_brand;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", truck_brand='" + truck_brand + '\'' +
                '}';
    }


}
