package com.projectlab.bme.ptl.domain.truck;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectlab.bme.ptl.domain.company.Company;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "truck")
public class Truck {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private @NotBlank(message = "Field can not be blank") String truck_brand;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;


    public Truck() {
    }

    public Truck(@NotBlank(message = "Field can not be blank") String truck_brand, Company company) {
        this.truck_brand = truck_brand;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruck_brand() {
        return truck_brand;
    }

    public void setTruck_brand(String truck_brand) {
        this.truck_brand = truck_brand;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", truck_brand='" + truck_brand + '\'' +
                ", company=" + company +
                '}';
    }
}
