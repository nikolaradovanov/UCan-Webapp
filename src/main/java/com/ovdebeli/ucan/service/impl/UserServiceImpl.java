package com.ovdebeli.ucan.service.impl;

import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.Role;
import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.repository.UserRepository;
import com.ovdebeli.ucan.service.QuoteService;
import com.ovdebeli.ucan.service.UserService;
import com.ovdebeli.ucan.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private QuoteService quoteService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,@Lazy QuoteService quoteService) {
        this.userRepository = userRepository;
        this.quoteService = quoteService;
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
                passwordEncoder.encode(userRegistrationDto.getPasswordHash()),
                new ArrayList<>());

        return saveUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPasswordHash(),mapRolesToAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<Role> roles) {
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public User getCurrentUser() {
        return userRepository.findByUsername(getCurrentUserUsername());
    }

    private String getCurrentUserUsername () {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return  ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @Override
    public List<Quote> getLikedQuotes() {

        List<Quote> likedQuotes = new ArrayList<>();

        List<Long> likedQuotesId = userRepository.findLikedQuotesId(getCurrentUser());

        for (Long i:likedQuotesId) {
            likedQuotes.add(quoteService.getQuoteById(i));
        }

        return likedQuotes;
    }

}
