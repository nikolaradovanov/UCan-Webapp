package com.ovdebeli.ucan.service.impl;

import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.repository.UserRepository;
import com.ovdebeli.ucan.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
