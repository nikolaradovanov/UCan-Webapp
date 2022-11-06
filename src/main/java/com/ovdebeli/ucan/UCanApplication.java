package com.ovdebeli.ucan;

import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UCanApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UCanApplication.class, args);
    }

    //BootLoader
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

//        User user1 = new User("Nikola", "Radovanovic", "M", "date", "ovdebeli", "HashCode");
//        userRepository.save(user1);
//
//        User user2 = new User("Marko", "Savic", "M", "date", "ovdebeli", "HashCode");
//        userRepository.save(user2);
//
//        User user3 = new User("Milica", "Markovic", "F", "date", "ovdebeli", "HashCode");
//        userRepository.save(user3);
    }

}
