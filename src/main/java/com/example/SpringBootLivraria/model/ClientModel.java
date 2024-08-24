package com.example.SpringBootLivraria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "TB_CLIENTS")
public class ClientModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank
    private String nome;
    @Column(unique = true)
    @NotBlank
    private String CPF;
    @NotBlank
    private String address;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    public ClientModel() {
    }

    public ClientModel(String nome, String CPF, String address, LocalDate data) {
        this.nome = nome;
        this.CPF = CPF;
        this.address = address;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
