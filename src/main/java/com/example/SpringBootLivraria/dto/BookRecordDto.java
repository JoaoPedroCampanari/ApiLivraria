package com.example.SpringBootLivraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookRecordDto(@NotBlank(message = "Name is required!") String nome,
                            @NotBlank(message = "Description is required!") String descricao,
                            @NotNull (message = "Date is required!")
                            @JsonFormat(pattern = "dd-MM-yyyy") LocalDate dataLancamentro) {
}
