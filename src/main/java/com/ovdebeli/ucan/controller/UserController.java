package com.ovdebeli.ucan.controller;

import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users/users";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/users/create_user";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {

        model.addAttribute("user",userService.getUserById(id));
        return "/users/edit_user";
    }

    @PostMapping("/users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {

        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setGender(user.getGender());
        existingUser.setUsername(user.getUsername());
        existingUser.setDateOfBirth(user.getDateOfBirth());
        existingUser.setPasswordHash(user.getPasswordHash());

        userService.saveUser(existingUser);

        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
