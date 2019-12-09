package com.projectlab.bme.ptl.domain.load;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectlab.bme.ptl.domain.truck.Truck;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "load")
public class Load {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private float load_price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "truck_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private @NotBlank(message = "Field can not be blank") Truck truck;

    public Load() {

    }

    public Load(float load_price, @NotBlank(message = "Field can not be blank") Truck truck) {
        this.load_price = load_price;
        this.truck = truck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLoad_price() {
        return load_price;
    }

    public void setLoad_price(float load_price) {
        this.load_price = load_price;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
