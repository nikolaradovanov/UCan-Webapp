package com.ovdebeli.ucan.service;

import com.ovdebeli.ucan.models.Quote;

import java.util.List;

public interface QuoteService {

    List<Quote> getAllQuotes();

    Quote saveQuote(Quote quote);

    Quote getQuoteById(Long id);

    Quote updateStudent(Quote quote);

    void deleteQuoteById(Long id);
}
