package com.projectlab.bme.ptl.rest;


import com.projectlab.bme.ptl.entity.Transaction;
import com.projectlab.bme.ptl.entity.Week;
import com.projectlab.bme.ptl.service.transaction.TransactionService;
import com.projectlab.bme.ptl.service.week.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class WeekRestController {

    WeekService weekService;

    @Autowired
    public WeekRestController(WeekService weekService) {
        this.weekService = weekService;
    }

    @GetMapping("/weeks")
    public List<Week> findAll(){
        return weekService.findAll();
    }


}
