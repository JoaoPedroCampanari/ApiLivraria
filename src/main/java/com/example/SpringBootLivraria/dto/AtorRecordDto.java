package com.example.SpringBootLivraria.dto;

import com.example.SpringBootLivraria.model.BookModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AtorRecordDto(@NotBlank(message = "Name is required!") String nome,
                            String bioDesc,
                            @NotNull(message = "Idade is required!") Integer idade,
                            @NotBlank(message = "Email is required!") String email){
}
