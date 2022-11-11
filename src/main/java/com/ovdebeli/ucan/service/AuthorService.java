package com.ovdebeli.ucan.service;

import com.ovdebeli.ucan.models.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author saveAuthor(Author author);
    Author getAuthorById(Long id);
    Author updateAuthor(Author author);
    void deleteAuthorById(Long id);
}
