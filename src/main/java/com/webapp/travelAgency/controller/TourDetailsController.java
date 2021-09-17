package com.webapp.travelAgency.controller;

import com.webapp.travelAgency.model.Tour;
import com.webapp.travelAgency.model.TourDetails;
import com.webapp.travelAgency.service.tour.TourService;
import com.webapp.travelAgency.service.tour.details.TourDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TourDetailsController {
    @Autowired private TourService tourService;
    @Autowired private TourDetailsService tourDetailsService;

    @GetMapping("/showTourDetails/{tourId}")
    public String showTourDetails(@PathVariable Long tourId, ModelMap modelMap) {
        Tour tour = tourService.getTourByIdWithComments(tourId);
        if(tour != null) {
            modelMap.put("tour", tour);
            return "tour-details";
        }
        return "redirect:/showOffer";
    }

    @GetMapping("/editTourDetails/{tourId}")
    public String editTourDetails(@PathVariable Long tourId, ModelMap modelMap) {
        Tour tour = tourService.getTourById(tourId);
        if(tour != null) {
            modelMap.put("tourDetails", tour.getTourDetails());
            return "form-tour-details";
        }
        return "redirect:/showOffer";
    }

    @PostMapping("/processFormTourDetails")
    public String processFormTourDetails(@ModelAttribute TourDetails tourDetails) {
        tourDetailsService.saveTourDetails(tourDetails);
        return "redirect:/showOffer";
    }
}
