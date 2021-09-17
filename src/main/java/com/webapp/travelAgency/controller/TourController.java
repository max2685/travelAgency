package com.webapp.travelAgency.controller;

import com.webapp.travelAgency.model.Tour;
import com.webapp.travelAgency.service.tour.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class TourController {
    @Autowired private TourService tourService;

    @GetMapping("/addTour")
    public String showForm(ModelMap modelMap) {
        modelMap.put("tour", new Tour());
        return "form";
    }

    @PostMapping("/processForm")
    public String showTourData(@Valid @ModelAttribute Tour tour, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }
        tourService.saveTour(tour);
        return "redirect:showOffer";
    }

    @GetMapping("/showOffer")
    public String getTours(ModelMap modelMap) {
        List<Tour> tours = tourService.getAllTours();
        modelMap.put("tours", tours);
        return "tours";
    }

    @GetMapping("/deleteTour/{id}")
    public String deleteTour(@PathVariable Long id) {
        Tour tour = tourService.getTourById(id);
        if(tour != null) {
            tourService.deleteTour(id);
        }
        return "redirect:/showOffer";
    }

    @GetMapping("/editTour/{id}")
    public String editTour(@PathVariable Long id, ModelMap modelMap) {
        Tour tour = tourService.getTourById(id);
        if(tour != null) {
            modelMap.put("tour", tour);
            return "form";
        }
        return "redirect:/showOffer";
    }

    @GetMapping("//addUserToTour/{id}")
    public String addUserToTour(@PathVariable Long id, Principal principal) {
        tourService.addUserToTour(id, principal.getName());
        return "redirect:/showOffer";
    }

    @GetMapping("/showOfferForNextMonth")
    public String hetToursForTheNExtMonth(ModelMap modelMap) {
        List<Tour> tours = tourService.getAllForNextMonth();
        modelMap.put("tours", tours);
        return "tours";
    }
}
