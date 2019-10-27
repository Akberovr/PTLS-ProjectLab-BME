package com.projectlab.bme.ptl.dao.address;

import com.projectlab.bme.ptl.entity.Address;

import java.util.List;

public interface AddressDAO {


    public List<Address> findAll();

    public Address findById(int theId);

    public void save(Address theAddress);

    public void deleteById(int theId);

}
