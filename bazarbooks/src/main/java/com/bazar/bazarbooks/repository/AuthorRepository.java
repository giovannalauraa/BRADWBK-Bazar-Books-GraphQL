package br.edu.ifsp.graphql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifsp.graphql.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
}
