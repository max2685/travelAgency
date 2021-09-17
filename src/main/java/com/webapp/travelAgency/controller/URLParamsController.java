package com.webapp.travelAgency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class URLParamsController {

    @RequestMapping("/welcome")
    public String showParams(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("Parameter" + name);
        return "home";
    }

    @RequestMapping("/welcome2")
    public String showParamsV2(@RequestParam(defaultValue = "john") String name) {
        System.out.println("Parameter" + name);
        return "home";
    }
}
