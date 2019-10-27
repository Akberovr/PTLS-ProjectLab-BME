package com.projectlab.bme.ptl.rest;


import com.projectlab.bme.ptl.entity.Atm;
import com.projectlab.bme.ptl.service.atm.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AtmRestController {

    AtmService atmService;

    @Autowired
    public AtmRestController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/atms")
    public List<Atm> findAll(){
        return atmService.findAll();
    }

}
