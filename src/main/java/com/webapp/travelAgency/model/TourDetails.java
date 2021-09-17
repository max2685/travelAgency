package com.webapp.travelAgency.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tour_details")
public class TourDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    @Column(length = 2000)
    private String description;

//    uncomment if you want to have bidirectional mapping
//    @OneToOne(mappedBy = "tour_details")
//    private Tour tour;
}
