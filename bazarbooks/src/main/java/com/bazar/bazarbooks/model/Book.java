package com.bazar.bazarbooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    private String description;
    private String price;
    private double rating;
    @Column(name = "review_count")
    private int reviewCount;
    private String store;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;
}
