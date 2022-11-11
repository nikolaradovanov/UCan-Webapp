package com.ovdebeli.ucan.service;

import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User saveUser(User user);
    User save(UserRegistrationDto userRegistrationDto);
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUserById(Long id);
}
