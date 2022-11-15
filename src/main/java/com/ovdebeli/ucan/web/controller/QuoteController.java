package com.ovdebeli.ucan.web.controller;

import com.ovdebeli.ucan.models.Author;
import com.ovdebeli.ucan.models.Category;
import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.service.AuthorService;
import com.ovdebeli.ucan.service.CategoryService;
import com.ovdebeli.ucan.service.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuoteController {

    private QuoteService quoteService;
    private AuthorService authorService;
    private CategoryService categoryService;


    public QuoteController(QuoteService quoteService, AuthorService authorService, CategoryService categoryService) {
        this.quoteService = quoteService;
        this.authorService = authorService;
        this.categoryService = categoryService;
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
        return "/quotes/edit_quote";
    }

    @PostMapping("/quotes/edit/{id}")
    public String updateQuote(@PathVariable Long id, @ModelAttribute("quote") Quote quote) {

        Quote existingQuote = quoteService.getQuoteById(id);
        existingQuote.setId(id);
        existingQuote.setAuthor(quote.getAuthor());
        existingQuote.setCategory(quote.getCategory());
        existingQuote.setText(quote.getText());
        quoteService.saveQuote(existingQuote);

        return "redirect:/quotes";
    }

    @GetMapping("/quotes/delete/{id}")
    public String deleteQuote(@PathVariable Long id) {

        quoteService.deleteQuoteById(id);
        return "redirect:/quotes";
    }
}
