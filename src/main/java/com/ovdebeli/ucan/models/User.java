package com.ovdebeli.ucan.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(name = "first_name",nullable = false)
    String firstName;
    @Column(name = "last_name",nullable = false)
    String lastName;
    @Column(name = "gender",nullable = false)
    String gender;
    @Column(name = "dob",nullable = false)
    SimpleDateFormat dateOfBirth;
    @Column(name = "last_name",nullable = false)
    String username;

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column(name = "password_hash",nullable = false)
    String passwordHash;

    public User() {
    }

    public User(String firstName, String lastName, String gender, SimpleDateFormat dateOfBirth, String username, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public SimpleDateFormat getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(SimpleDateFormat dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
