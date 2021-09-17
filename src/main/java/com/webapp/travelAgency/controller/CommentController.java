package com.webapp.travelAgency.controller;

import com.webapp.travelAgency.model.Comment;
import com.webapp.travelAgency.model.Tour;
import com.webapp.travelAgency.service.tour.TourService;
import com.webapp.travelAgency.service.tour.comments.TourCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommentController {
    @Autowired private TourService tourService;
    @Autowired private TourCommentsService tourCommentsService;

    @GetMapping("/addComment")
    public String showCommentForm(ModelMap modelMap) {
        List<Tour> tours = tourService.getAllTours();
        modelMap.put("tours", tours);
        modelMap.put("comment", new Comment());
        return "form-comment";
    }

    @PostMapping("/processFromComment")
    public String addCommentData(@ModelAttribute Comment comment) {
        tourCommentsService.saveComment(comment);
        return "home";
    }
}
