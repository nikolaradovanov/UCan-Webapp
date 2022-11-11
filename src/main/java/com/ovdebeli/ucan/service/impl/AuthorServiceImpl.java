package com.ovdebeli.ucan.service.impl;

import com.ovdebeli.ucan.models.Author;
import com.ovdebeli.ucan.repository.AuthorRepository;
import com.ovdebeli.ucan.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {

        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
