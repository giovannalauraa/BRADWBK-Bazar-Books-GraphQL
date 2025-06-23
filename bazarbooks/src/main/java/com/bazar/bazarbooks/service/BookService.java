package com.bazar.bazarbooks.service;

import com.bazar.bazarbooks.dto.BookInput;
import com.bazar.bazarbooks.model.Book;
import com.bazar.bazarbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(BookInput input) {
        Author author = authorRepository.findById(input.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setImageUrl(input.getImageUrl());
        book.setDescription(input.getDescription());
        book.setPrice(input.getPrice());
        book.setRating(input.getRating());
        book.setReviewCount(input.getReviewCount());
        book.setStore(input.getStore());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public boolean updateBook(int id, BookInput bookInput) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            book.setTitle(bookInput.getTitle());
            book.setImageUrl(bookInput.getImageUrl());
            book.setDescription(bookInput.getDescription());
            book.setPrice(bookInput.getPrice());
            book.setRating(bookInput.getRating());
            book.setReviewCount(bookInput.getReviewCount());
            book.setStore(bookInput.getStore());
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public boolean deleteBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
