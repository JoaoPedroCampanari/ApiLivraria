package com.example.SpringBootLivraria.repository;

import com.example.SpringBootLivraria.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID>{

    boolean existsByCPF(String cpf);

}
