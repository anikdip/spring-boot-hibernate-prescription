package com.example.prescription.service;

import com.example.prescription.model.User;
import com.example.prescription.web.dto.UserRegistrationDto;
import com.example.prescription.web.dto.UserUpdateDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    User save(UserUpdateDto registration, long id);

    public void deleteUser(User user);

    List<User> findAll();

    User findById(long id);
}
