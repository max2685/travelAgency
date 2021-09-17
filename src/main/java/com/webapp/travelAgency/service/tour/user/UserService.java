package com.webapp.travelAgency.service.tour.user;

import com.webapp.travelAgency.model.User;

public interface UserService {
    void createNewAccount(User user);
    boolean loginExists(String login);
}
