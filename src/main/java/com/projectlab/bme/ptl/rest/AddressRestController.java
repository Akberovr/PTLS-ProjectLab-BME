package com.projectlab.bme.ptl.rest;


import com.projectlab.bme.ptl.entity.Address;
import com.projectlab.bme.ptl.entity.Employee;
import com.projectlab.bme.ptl.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AddressRestController {

    AddressService addressService;

    @Autowired
    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public List<Address> findAll(){
        return addressService.findAll();
    }


    @PostMapping("/address/{addressid}")
    public Address addAddress(@RequestBody Address theAddress){

        theAddress.setAddress_id(0);

        addressService.save(theAddress);

        return theAddress;
    }
}
