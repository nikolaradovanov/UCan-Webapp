package com.ovdebeli.ucan.service.impl;

import com.ovdebeli.ucan.models.Role;
import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.repository.UserRepository;
import com.ovdebeli.ucan.service.UserService;
import com.ovdebeli.ucan.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getGender(),
                userRegistrationDto.getDateOfBirth(),
                userRegistrationDto.getUsername(),
                Arrays.asList(new Role("ROLE_USER")),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPasswordHash());

        return saveUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
