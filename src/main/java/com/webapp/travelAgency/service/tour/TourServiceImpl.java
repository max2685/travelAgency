package com.webapp.travelAgency.service.tour;

import com.webapp.travelAgency.error.TourNotFoundException;
import com.webapp.travelAgency.repository.TourRepository;
import com.webapp.travelAgency.repository.UserRepository;
import com.webapp.travelAgency.model.Tour;
import com.webapp.travelAgency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TourServiceImpl implements TourService {
    @Autowired private TourRepository tourRepository;
    @Autowired private UserRepository userRepository;

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Long id) { return tourRepository.findById(id)
            .orElseThrow(() -> new TourNotFoundException("Tour id " + id + " not found")); }

    @Override
    public Tour getTourByIdWithComments(Long id) { return tourRepository.getByIdWithComments(id); }

    @Override
    public void saveTour(Tour tour) { tourRepository.save(tour); }

    @Override
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public void addUserToTour(Long tourId, String login) {
        Tour tour = getTourById(tourId);
        if(tour.getUsers() == null) {
            tour.setUsers(new ArrayList<>());
        }
        User user = userRepository.findByLogin(login);
        if(user != null) {
            tour.getUsers().add(user);
            saveTour(tour);
        }
    }

    @Override
    public List<Tour> getAllForNextMonth() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(calendar.MONTH, 1);
        return tourRepository.findByDateBetween(currentDate, calendar.getTime());
    }
}
