package com.example.SpringBootLivraria.repository;

import com.example.SpringBootLivraria.model.AtorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AtorRepository extends JpaRepository<AtorModel, UUID> {

    boolean existsByNome(String nome);
    boolean existsByEmail(String email);
}
