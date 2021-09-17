package com.webapp.travelAgency.restcontrollers;

import com.webapp.travelAgency.error.TourErrorResponse;
import com.webapp.travelAgency.error.TourNotFoundException;
import com.webapp.travelAgency.model.Tour;
import com.webapp.travelAgency.service.tour.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TourRestController {
    @Autowired private TourService tourService;

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> getTours() {
        List<Tour> tours = tourService.getAllTours();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Method", "getTours");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(tours);
    }

    @GetMapping("/tours/{id}")
    public ResponseEntity<Tour> getTour(@PathVariable Long id) {
        Tour tour = tourService.getTourById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Method", "getTour");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(tour);
    }

    @PostMapping(path = "/tours", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tour> saveTour(@RequestBody Tour tour) {
        //set id to 0 to be sure that save method will be invoked. If id will be in Tour, when it will be replaced
        tour.setId((long) 0);
        tourService.saveTour(tour);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Method", "saveTour");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .headers(httpHeaders)
                .body(tour);
    }

    @PutMapping("/tours")
    public ResponseEntity<Void> editTour(@RequestBody Tour tour) {
        Tour t = tourService.getTourById(tour.getId());
        tourService.saveTour(t);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Method", "editTour");

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .headers(httpHeaders)
                .build();
    }

    @DeleteMapping("/tours/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        Tour tour = tourService.getTourById(id);
        tourService.deleteTour(tour.getId());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Method", "saveTour");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(null);
    }

    @ExceptionHandler
    public ResponseEntity<TourErrorResponse> handleException(TourNotFoundException e) {
        TourErrorResponse error = new TourErrorResponse();
        error.setIdStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<TourErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
}
