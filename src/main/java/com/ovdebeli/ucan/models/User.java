package com.ovdebeli.ucan.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_table", uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "gender", nullable = false)
    String gender;
    @Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date dateOfBirth;
    @Column(name = "username", nullable = false)
    String username;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "password_hash", nullable = false)
    String passwordHash;
    @Column(name = "last_shown_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date lastShownDate;

    @ManyToOne
    @JoinColumn(name = "last_shown_quote_id")
    Quote lastShownQuote;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    Collection<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_preferences",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "quote_id", referencedColumnName = "id"))
    List<Quote> likedQuotes;

    public User() {
    }

    public User(String firstName, String lastName, String gender, Date dateOfBirth, String username,
            Collection<Role> roles, String email, String passwordHash, List<Quote> likedQuotes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.roles = roles;
        this.email = email;
        this.passwordHash = passwordHash;
        this.likedQuotes = likedQuotes;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() { return roles; }

    public void setRoles(Collection<Role> roles) { this.roles = roles; }

    public List<Quote> getLikedQuotes() {
        return likedQuotes;
    }

    public void setLikedQuotes(List<Quote> likedQuotes) {
        this.likedQuotes = likedQuotes;
    }

    public Quote getLastShownQuote() {
        return lastShownQuote;
    }

    public void setLastShownQuote(Quote lastShownQuote) {
        this.lastShownQuote = lastShownQuote;
    }

    public void likeQuote(Quote quote) {
        this.likedQuotes.add(quote);
    }
}
