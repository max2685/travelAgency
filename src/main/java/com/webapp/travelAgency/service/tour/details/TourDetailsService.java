package com.webapp.travelAgency.service.tour.details;

import com.webapp.travelAgency.model.Tour;
import com.webapp.travelAgency.model.TourDetails;

public interface TourDetailsService {
    TourDetails getTourDetailsById(Long id);
    void saveTourDetails(TourDetails tour);
    void deleteTourDetails(Long id);
}
