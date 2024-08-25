package com.example.SpringBootLivraria.repository;

import com.example.SpringBootLivraria.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {
    boolean existsByNome(String nome);
}
