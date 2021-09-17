package com.webapp.travelAgency.service.tour.details;

import com.webapp.travelAgency.repository.TourDetailsRepository;
import com.webapp.travelAgency.model.TourDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService {
    @Autowired private TourDetailsRepository tourDetailsRepository;

    @Override
    public TourDetails getTourDetailsById(Long id) {
        return tourDetailsRepository.getById(id);
    }

    @Override
    public void saveTourDetails(TourDetails tourDetails) {
        tourDetailsRepository.save(tourDetails);
    }

    @Override
    public void deleteTourDetails(Long id) {
        tourDetailsRepository.deleteById(id);
    }
}
