package com.webapp.travelAgency.controller;

import com.webapp.travelAgency.externalapi.model.openweather.OpenWeatherMap;
import com.webapp.travelAgency.service.external.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired private ExternalApiService externalApiService;

    @RequestMapping("/")
    public String getHome(HttpServletRequest request, ModelMap modelMap) {
        OpenWeatherMap openWeatherMap = externalApiService.getData(request);
        modelMap.put("openWeatherMap", openWeatherMap);
        return "home";
    }
}
