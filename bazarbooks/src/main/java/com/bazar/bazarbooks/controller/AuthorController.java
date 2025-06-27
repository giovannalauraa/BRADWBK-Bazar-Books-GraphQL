package com.bazar.bazarbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bazar.bazarbooks.dto.AuthorInput;
import com.bazar.bazarbooks.model.Author;
import com.bazar.bazarbooks.model.Book;
import com.bazar.bazarbooks.repository.AuthorRepository;
import com.bazar.bazarbooks.service.AuthorService;

import jakarta.transaction.Transactional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    @QueryMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author getAuthorById(@Argument int id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public Author createAuthor(@Argument AuthorInput authorInput) {
        Author author = authorService.createAuthor(authorInput);
        return author;
    }

    @MutationMapping
    public Author updateAuthor(@Argument int id, @Argument AuthorInput authorInput) {
        boolean updated = authorService.updateAuthor(id, authorInput);
        if (updated) {
            return authorService.getAuthorById(id);
        }
        return null;
    }
 
    @MutationMapping
    @Transactional
    public Boolean deleteAuthor(@Argument int id) {
        return authorService.deleteAuthor(id);
    }

}
