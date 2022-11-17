package com.ovdebeli.ucan.service.impl;

import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.repository.QuoteRepository;
import com.ovdebeli.ucan.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id).get();
    }

    @Override
    public Quote updateStudent(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public void deleteQuoteById(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public Quote getQOTD(User user) {

        List<Quote> quotesList = quoteRepository.findAll();

        if (!quotesList.isEmpty()) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, quotesList.size());
            return quotesList.get(randomNum);
        } else {
            return null;
        }
    }
}
