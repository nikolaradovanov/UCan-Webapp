package com.ovdebeli.ucan.service;

import com.ovdebeli.ucan.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User saveUser(User user);
}
