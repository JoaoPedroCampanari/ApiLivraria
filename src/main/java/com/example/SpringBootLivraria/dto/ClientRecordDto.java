package com.example.SpringBootLivraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientRecordDto(@NotBlank(message = "Name is required!") String nome,
                              @NotBlank(message = "CPF is required!") String CPF,
                              @NotNull(message = "Birth date is required!") @JsonFormat(pattern = "dd-MM-yyyy") LocalDate data,
                              @NotBlank(message = "Address is required!") String address) {
}
