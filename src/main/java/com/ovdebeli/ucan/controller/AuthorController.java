package com.ovdebeli.ucan.controller;

import com.ovdebeli.ucan.models.Author;
import com.ovdebeli.ucan.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    private AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "/authors/authors";
    }

    @GetMapping("/authors/new")
    public String createAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "/authors/create_author";
    }

    @PostMapping("/authors")
    public String saveAuthor(@ModelAttribute("author") Author author) {

        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {

        model.addAttribute("author",authorService.getAuthorById(id));
        return "/authors/edit_author";
    }

    @PostMapping("/authors/edit/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute("author") Author author) {

        Author existingAuthor = authorService.getAuthorById(id);
        existingAuthor.setId(id);
        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setBiography(author.getBiography());
        authorService.saveAuthor(existingAuthor);

        return "redirect:/authors";
    }

    @GetMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {

        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
