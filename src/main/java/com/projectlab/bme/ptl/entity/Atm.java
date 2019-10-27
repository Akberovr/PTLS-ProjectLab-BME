package com.projectlab.bme.ptl.entity;


import javax.persistence.*;

@Entity
@Table(name = "atm")
public class Atm {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atm_id")
    private int atm_id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="atm_address_id")
    private Address atm_address_id;

    @Column(name = "atm_deposit_fl")
    private boolean atm_deposit_fl;

    public int getAtm_id() {
        return atm_id;
    }

    public void setAtm_id(int atm_id) {
        this.atm_id = atm_id;
    }

    public Address getAtm_address_id() {
        return atm_address_id;
    }

    public void setAtm_address_id(Address atm_address_id) {
        this.atm_address_id = atm_address_id;
    }

    public boolean isAtm_deposit_fl() {
        return atm_deposit_fl;
    }

    public void setAtm_deposit_fl(boolean atm_deposit_fl) {
        this.atm_deposit_fl = atm_deposit_fl;
    }



    public Atm() {
    }

    public Atm(boolean atm_deposit_fl) {
        this.atm_deposit_fl = atm_deposit_fl;
    }


}
