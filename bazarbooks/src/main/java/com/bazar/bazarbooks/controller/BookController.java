package com.bazar.bazarbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bazar.bazarbooks.dto.BookInput;
import com.bazar.bazarbooks.model.Book;
import com.bazar.bazarbooks.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument int id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Book createBook(@Argument BookInput bookInput) {
        return bookService.createBook(bookInput);
    }

    @MutationMapping
    public Book updateBook(@Argument int id, @Argument BookInput bookInput) {
        boolean updated = bookService.updateBook(id, bookInput);
        if (updated) {
            return bookService.getBookById(id);
        }
        return null;
    }

    @MutationMapping
    public String deleteBook(@Argument int id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted ? "Livro apagado com sucesso!" : "Livro não encontrado.";
    }

}
