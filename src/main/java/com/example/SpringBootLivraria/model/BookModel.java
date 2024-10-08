package com.example.SpringBootLivraria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_Books")
public class BookModel extends RepresentationModel<BookModel> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "ator_id")
    private AtorModel atorModel;

    @ManyToMany(mappedBy = "books")
    List<ClientModel> clientes;

    public BookModel (){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(@NotNull LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    public AtorModel getAtorModel() {
        return atorModel;
    }

    public void setAtorModel(AtorModel atorModel) {
        this.atorModel = atorModel;
    }

    public List<ClientModel> getClintes() {
        return clientes;
    }

    public void setClintes(List<ClientModel> clintes) {
        this.clientes = clintes;
    }
}
