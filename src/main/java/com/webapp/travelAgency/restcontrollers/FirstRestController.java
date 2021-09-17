package com.webapp.travelAgency.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

    @GetMapping("/rest")
    public String hello() {
        return "sdafsgfdhg";
    }
}
