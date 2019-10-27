package com.projectlab.bme.ptl.service.address;

import com.projectlab.bme.ptl.entity.Address;

import java.util.List;

public interface AddressService {

    public List<Address> findAll();

    public Address findById(int theId);

    public void save(Address theAddress);

    public void deleteById(int theId);

}
