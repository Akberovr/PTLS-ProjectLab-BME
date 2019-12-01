package com.projectlab.bme.ptl.domain.route;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectlab.bme.ptl.domain.company.Company;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
@Table(name = "route")
public class Route implements Serializable {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private @NotBlank(message = "Field can not be blank") String route_start;

    private @NotBlank(message = "Field can not be blank") String route_destination;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;

    public Route() {

    }

    public Route(@NotBlank(message = "Field can not be blank") String route_start, @NotBlank(message = "Field can not be blank") String route_destination, Company company) {
        this.route_start = route_start;
        this.route_destination = route_destination;
        this.company = company;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_destination() {
        return route_destination;
    }

    public void setRoute_destination(String route_destination) {
        this.route_destination = route_destination;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", route_start='" + route_start + '\'' +
                ", route_destination='" + route_destination + '\'' +
                '}';
    }
}
