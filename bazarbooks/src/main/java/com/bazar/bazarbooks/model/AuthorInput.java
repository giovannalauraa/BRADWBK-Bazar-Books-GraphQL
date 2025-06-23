package br.edu.ifsp.graphql.dto;

import java.util.List;

import br.edu.ifsp.graphql.model.Book;

public class AuthorInput {

    private String name;
    private String imageUrl;
    private String description;
    private List<Book> books;

    public AuthorInput() {
    }

    public AuthorInput(List<Book> books, String description, String imageUrl, String name) {
        this.books = books;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
