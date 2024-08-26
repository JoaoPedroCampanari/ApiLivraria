package com.example.SpringBootLivraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ATORS")
public class AtorModel extends RepresentationModel<AtorModel> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    @NotBlank
    private String nome;
    private String bioDesc;
    @NotNull
    private Integer idade;
    @Column(unique = true)
    @NotBlank
    private String email;

    public AtorModel(){

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

    public String getBioDesc() {
        return bioDesc;
    }

    public void setBioDesc(String bioDesc) {
        this.bioDesc = bioDesc;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
