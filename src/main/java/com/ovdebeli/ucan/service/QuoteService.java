package com.ovdebeli.ucan.service;

import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.User;

import java.util.List;

public interface QuoteService {

    List<Quote> getAllQuotes();

    List<Quote> getQuotesByCategory();

    Quote saveQuote(Quote quote);

    Quote getQuoteById(Long id);

    Quote updateStudent(Quote quote);

    void deleteQuoteById(Long id);

    Quote getQOTD(User user);
}
