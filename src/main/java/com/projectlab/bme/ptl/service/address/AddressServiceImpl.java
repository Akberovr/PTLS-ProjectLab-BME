package com.projectlab.bme.ptl.service.address;

import com.projectlab.bme.ptl.dao.address.AddressDAO;
import com.projectlab.bme.ptl.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    AddressDAO addressDAO;

    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    @Transactional
    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    @Override
    @Transactional
    public Address findById(int theId) {
        return addressDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Address theAddress) {
        addressDAO.save(theAddress);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        addressDAO.deleteById(theId);
    }
}
