package com.ovdebeli.ucan.service.impl;

import com.ovdebeli.ucan.models.Category;
import com.ovdebeli.ucan.models.Quote;
import com.ovdebeli.ucan.models.User;
import com.ovdebeli.ucan.repository.QuoteRepository;
import com.ovdebeli.ucan.service.CategoryService;
import com.ovdebeli.ucan.service.QuoteService;
import com.ovdebeli.ucan.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;
    private CategoryService categoryService;
    private UserService userService;

    public QuoteServiceImpl(QuoteRepository quoteRepository, CategoryService categoryRepository, UserService userRepository) {
        this.quoteRepository = quoteRepository;
        this.categoryService = categoryRepository;
        this.userService = userRepository;
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
    public List<Quote> getQuotesByCategory() {

        return null;
    }

    private Quote randomQuote() {

        List<Quote> allQuotesList = quoteRepository.findAll();
        int randomNum = ThreadLocalRandom.current().nextInt(0, allQuotesList.size());
        return allQuotesList.get(randomNum);
    }

    private List<Quote> quotesByCategory(List<Quote> quotes, Category selection) {

        List<Quote> listToReturn = new ArrayList<Quote>();

        for (Quote quote:quotes) {

            if (quote.getCategory().getId() == selection.getId()) {
                listToReturn.add(quote);
            }
        }

        return listToReturn;
    }

    @Override
    public Quote getQOTD(User user) {

        List<Quote> likedQuotesList = userService.getLikedQuotes();

        List<Quote> allQuotesList = quoteRepository.findAll();

        List<Category> categories = categoryService.getAllCategories();

        int[] oddsArray = new int[categories.size()];

        if (!allQuotesList.isEmpty()) {

            int numberOfLikedQuotes = likedQuotesList.size();
            int randomNum = ThreadLocalRandom.current().nextInt(0, 110) + 1;

            if (numberOfLikedQuotes < 10 || randomNum > 100) {
                return randomQuote();
            }
            //Calculate odds
            for (int i = 0; i < categories.size(); i++) {

                List<Quote> quotesByCategory = quotesByCategory(likedQuotesList,categories.get(i));
                int percent = (quotesByCategory.size() * 100)/numberOfLikedQuotes;
                oddsArray[i] = percent;
            }

            Arrays.sort(oddsArray);

            //Find most appropriate category
            Long idOfCategoryToChose = 0L;
            int sum = 0;
            for (int i = 0; i < categories.size(); i++) {

                sum += oddsArray[i];

                if (randomNum <= sum) {
                    idOfCategoryToChose = categories.get(i).getId();
                    break;
                }
            }

            //Return random quote of category
            Category categoryToChoose = categoryService.getCategoryById(idOfCategoryToChose);
            List<Quote> quotesByCategory = quotesByCategory(likedQuotesList,categoryToChoose);

            randomNum = ThreadLocalRandom.current().nextInt(0, quotesByCategory.size());

            return quotesByCategory.get(randomNum);
        }

        return null;
    }

//    public void testQOTD() {
//
//        int truth = 0, success = 0, motiv = 0, money = 0;
//
//        for (int i =0; i < 100; i++) {
//            Quote quote = getQOTD(userService.getCurrentUser());
//            String name = quote.getCategory().getName();
//
//            switch (name) {
//                case "Money" :
//                    money++;
//                    break;
//                case "Success":
//                    success++;
//                    break;
//                case "Motivational":
//                    motiv++;
//                    break;
//                case "Truth":
//                    truth++;
//                    break;
//                default:
//                    break;
//            }
//        }
//
//        System.out.println("Results:");
//        System.out.println(categoryService.getCategoryById(1L).getName()+ " " + motiv);
//        System.out.println(categoryService.getCategoryById(2L).getName()+ " " + money);
//        System.out.println(categoryService.getCategoryById(3L).getName()+ " " + success);
//        System.out.println(categoryService.getCategoryById(4L).getName()+ " " + truth);
//    }
}
