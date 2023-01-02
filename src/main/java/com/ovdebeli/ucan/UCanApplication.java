package com.ovdebeli.ucan;

import com.ovdebeli.ucan.models.Author;
import com.ovdebeli.ucan.models.Category;
import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.service.AuthorService;
import com.ovdebeli.ucan.service.CategoryService;
import com.ovdebeli.ucan.service.QuoteService;
import com.ovdebeli.ucan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UCanApplication implements CommandLineRunner {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(UCanApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

//        Author author = new Author("Abraham","Lincoln","Bio");
//        authorService.saveAuthor(author);
//        Category categoryMotivational = new Category("Motivational","Description");
//        categoryService.saveCategory(categoryMotivational);
//        Category categoryMoney = new Category("Money","Description");
//        categoryService.saveCategory(categoryMoney);
//        Category categorySuccess = new Category("Success","Description");
//        categoryService.saveCategory(categorySuccess);
//        Category categoryTruth = new Category("Truth","Description");
//        categoryService.saveCategory(categoryTruth);
//        Quote quote1 = new Quote("Text1",author,categoryMoney);
//        quoteService.saveQuote(quote1);
//        Quote quote2 = new Quote("Text2",author,categoryMoney);
//        quoteService.saveQuote(quote2);
//        Quote quote3 = new Quote("Text3",author,categoryMoney);
//        quoteService.saveQuote(quote3);
//        Quote quote4 = new Quote("Text4",author,categoryMotivational);
//        quoteService.saveQuote(quote4);
//        Quote quote5 = new Quote("Text5",author,categoryMotivational);
//        quoteService.saveQuote(quote5);
//        Quote quote6 = new Quote("Text6",author,categoryMotivational);
//        quoteService.saveQuote(quote6);
//        Quote quote7 = new Quote("Text7",author,categorySuccess);
//        quoteService.saveQuote(quote7);
//        Quote quote8 = new Quote("Text8",author,categorySuccess);
//        quoteService.saveQuote(quote8);
//        Quote quote9 = new Quote("Text9",author,categorySuccess);
//        quoteService.saveQuote(quote9);
//        Quote quote10 = new Quote("Text10",author,categoryTruth);
//        quoteService.saveQuote(quote10);
//        Quote quote11 = new Quote("Text11",author,categoryTruth);
//        quoteService.saveQuote(quote11);
//        Quote quote12 = new Quote("Text12",author,categoryTruth);
//        quoteService.saveQuote(quote12);

    }
}
