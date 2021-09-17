package com.webapp.travelAgency.service.tour;

import com.webapp.travelAgency.model.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<Tour> getAllTours();
    Tour getTourById(Long id);
    Tour getTourByIdWithComments(Long id);
    void saveTour(Tour tour);
    void deleteTour(Long id);
    void addUserToTour(Long tourId, String login);
    List<Tour> getAllForNextMonth();
}
