package com.projectlab.bme.ptl.entity;


import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int address_id;

    @Column(name = "address_street")
    private String address_street;

    @Column(name = "address_zip")
    private int address_zip;

    @Column(name = "address_geo_x")
    private int address_geo_x;

    @Column(name = "Address_geo_y")
    private int getAddress_geo_y;



    public Address() {

    }

    public Address(String address_street, int address_zip, int address_geo_x, int getAddress_geo_y) {
        this.address_street = address_street;
        this.address_zip = address_zip;
        this.address_geo_x = address_geo_x;
        this.getAddress_geo_y = getAddress_geo_y;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public int getAddress_zip() {
        return address_zip;
    }

    public void setAddress_zip(int address_zip) {
        this.address_zip = address_zip;
    }

    public float getAddress_geo_x() {
        return address_geo_x;
    }

    public void setAddress_geo_x(int address_geo_x) {
        this.address_geo_x = address_geo_x;
    }

    public float getGetAddress_geo_y() {
        return getAddress_geo_y;
    }

    public void setGetAddress_geo_y(int getAddress_geo_y) {
        this.getAddress_geo_y = getAddress_geo_y;
    }


    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address_street='" + address_street + '\'' +
                ", address_zip=" + address_zip +
                ", address_geo_x=" + address_geo_x +
                ", getAddress_geo_y=" + getAddress_geo_y +
                '}';
    }
}
