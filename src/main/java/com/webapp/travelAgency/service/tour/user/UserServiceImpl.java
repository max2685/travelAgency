package com.webapp.travelAgency.service.tour.user;

import com.webapp.travelAgency.model.Role;
import com.webapp.travelAgency.model.User;
import com.webapp.travelAgency.repository.RoleRepository;
import com.webapp.travelAgency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;

    @Override
    public void createNewAccount(User user) {
        user.setEnabled(true);
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);

        Role role = new Role();
        role.setLogin(user.getLogin());
        role.setRole("ROLE_CLIENT");
        roleRepository.save(role);
    }

    @Override
    public boolean loginExists(String login) {
        return userRepository.existsByLogin(login);
    }
}
