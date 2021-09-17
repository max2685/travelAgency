package com.webapp.travelAgency.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    @Column(length = 68)
    private String password;

    // Transient shows that this field will not be saved in db
    @Transient
    private String confirmedPassword;

    //user account can be enabled and disabled
    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "tour2user",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "tour_id"))
    private List<Tour> tours;
}
