package com.webapp.travelAgency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Configuration;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Tour {

    public Tour() {
        setTourDetails(new TourDetails());
    }

    public enum Continent{
        AFRICA, ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{tour.name.notBlank}")
    @Size(min = 3, message = "{tour.name.size}")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{tour.code.pattern}")
    private String code;

    private Continent continent;

    @NotNull(message = "{tour.date.notNull}")
    @Future(message = "{tour.date.future}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Min(value = 7, message = "{tour.duration}")
    @Max(value = 21, message = "{tour.duration}")
    private int duration;

    @Column(name = "all_inclusive")
    private boolean allInclusive = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_details_id")
    private TourDetails tourDetails;

    //mappedBy -> name of the field in comment class that contains information about primary key
    //cascade -> if tour is deleted, then all comments of this tour are deleted too
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(name = "tour2user",
               joinColumns = @JoinColumn(name = "tour_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
