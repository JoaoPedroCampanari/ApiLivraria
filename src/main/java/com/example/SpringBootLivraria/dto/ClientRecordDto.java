package com.example.SpringBootLivraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientRecordDto(@NotBlank String nome,
                              @NotBlank String CPF,
                              @NotNull @JsonFormat(pattern = "dd-MM-yyyy") LocalDate data,
                              @NotBlank String address) {
}
