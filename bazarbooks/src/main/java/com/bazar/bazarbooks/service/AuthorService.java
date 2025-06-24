package com.bazar.bazarbooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bazar.bazarbooks.dto.AuthorInput;
import com.bazar.bazarbooks.model.Author;
import com.bazar.bazarbooks.model.Book;
import com.bazar.bazarbooks.repository.AuthorRepository;
import com.bazar.bazarbooks.repository.BookRepository;

import java.util.Optional;
 
import jakarta.transaction.Transactional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

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

    @Transactional
    public boolean deleteAuthor(int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();

            List<Book> livros = author.getBooks();
            if (livros != null && !livros.isEmpty()) {
                for (Book livro : livros) {
                    livro.setAuthor(null);
                    bookRepository.save(livro);
                }
                bookRepository.flush();
            }

            authorRepository.delete(author);
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
