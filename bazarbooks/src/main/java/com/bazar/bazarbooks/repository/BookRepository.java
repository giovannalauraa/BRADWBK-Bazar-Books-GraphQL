package com.bazar.bazarbooks.repository;

import com.bazar.bazarbooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
