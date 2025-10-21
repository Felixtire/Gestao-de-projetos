package com.gestao.api.api.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

public record DadosParaCriarProjeto(

        @NotBlank
        String name,
        String description,
        LocalDate startDate ,

        LocalDate endDate
) {
}
