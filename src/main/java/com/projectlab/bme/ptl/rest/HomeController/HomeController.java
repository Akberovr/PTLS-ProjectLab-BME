package com.projectlab.bme.ptl.rest.HomeController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
