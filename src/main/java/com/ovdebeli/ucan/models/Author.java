package com.ovdebeli.ucan.models;

import javax.persistence.*;

@Entity
@Table(name = "author_table")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column (name = "first_name", nullable = false)
    String firstName;
    @Column (name = "last_name")
    String lastName;
    @Column (name = "biography")
    String biography;

    public Author() {
    }

    public Author(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String middleName) {
        this.biography = middleName;
    }
}
