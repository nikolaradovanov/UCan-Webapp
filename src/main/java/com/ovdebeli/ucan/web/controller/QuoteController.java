package com.ovdebeli.ucan.web.controller;

import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.service.AuthorService;
import com.ovdebeli.ucan.service.CategoryService;
import com.ovdebeli.ucan.service.QuoteService;
import com.ovdebeli.ucan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuoteController {

    private QuoteService quoteService;
    private AuthorService authorService;
    private CategoryService categoryService;
    private UserService userService;

    public QuoteController(QuoteService quoteService, AuthorService authorService, CategoryService categoryService, UserService userService) {
        this.quoteService = quoteService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/quotes")
    public String listQuotes(Model model) {
        model.addAttribute("quotes", quoteService.getAllQuotes());
        return "/quote/quotes";
    }

    @GetMapping("/quotes/new")
    public String createQuoteForm(Model model) {
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("categories",categoryService.getAllCategories());
        Quote quote = new Quote();
        model.addAttribute("quote", quote);

        return "/quote/create_quote";
    }

    @PostMapping("/quotes")
    public String saveQuote(@ModelAttribute("quote") Quote quote,
                            @RequestParam(name = "authorId") Long authorId,
                            @RequestParam(name = "categoryId")Long categoryId) {
        quote.setAuthor(authorService.getAuthorById(authorId));
        quote.setCategory(categoryService.getCategoryById(categoryId));
        quoteService.saveQuote(quote);
        return "redirect:/quotes";
    }

    @GetMapping("/quote/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {

        model.addAttribute("quote",quoteService.getQuoteById(id));
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "/quote/edit_quote";
    }

    @PostMapping("/quote/edit/{id}")
    public String updateQuote(@PathVariable Long id, @ModelAttribute("quote") Quote quote,
                              @RequestParam(name = "authorId") Long authorId,
                              @RequestParam(name = "categoryId")Long categoryId) {

        return "redirect:/quotes";
    }

    @GetMapping("/quote/delete/{id}")
    public String deleteQuote(@PathVariable Long id) {

        quoteService.deleteQuoteById(id);
        return "redirect:/quotes";
    }

    @GetMapping("/quotes/qotd")
    public String getQOTD(Model model) {
        model.addAttribute("quote", quoteService.getQOTD(userService.getCurrentUser()));

        return "/quote/qotd";
    }

    @GetMapping("/quotes/card")
    public String getQuoteCard(Model model) {
        model.addAttribute("quote", quoteService.getQOTD(userService.getCurrentUser()));

        return "/quote/card_quote";
    }
}
