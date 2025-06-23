package com.bazar.bazarbooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bazar.bazarbooks.dto.AuthorInput;
import com.bazar.bazarbooks.model.Author;
import com.bazar.bazarbooks.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author createAuthor(AuthorInput authorInput) {
        Author author = new Author();
        author.setName(authorInput.getName());
        author.setDescription(authorInput.getDescription());
        author.setImageUrl(authorInput.getImageUrl());
        author.setBooks(authorInput.getBooks());
        return authorRepository.save(author);
    }

    public boolean deleteAuthor(int id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id); 
            return true;  
        }
        return false; 
    }

    public boolean updateAuthor(int id, AuthorInput authorInput) {
        if (authorRepository.existsById(id)) {
            Author author = new Author();
            author.setIdAuthor(id);  
            author.setName(authorInput.getName());
            author.setDescription(authorInput.getDescription());
            author.setImageUrl(authorInput.getImageUrl());
            author.setBooks(authorInput.getBooks());
            authorRepository.save(author);
            return true;  
        }
        return false;  
    }
}
