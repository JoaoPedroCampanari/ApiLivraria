package com.example.SpringBootLivraria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record AtorRecordDto(@NotBlank(message = "Name is required!") String nome,
                            String bioDesc,
                            @NotNull(message = "Idade is required!") Integer idade,
                            @NotBlank(message = "Email is required!") String email){
}
