package com.example.SpringBootLivraria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "TB_CLIENTS")
public class ClientModel extends RepresentationModel<ClientModel> implements Serializable {

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
    @Column(name = "birthdate")
    private LocalDate data;

    @ManyToMany
    @JoinTable(name = "client_book", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<BookModel> books;

    public ClientModel() {
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

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
