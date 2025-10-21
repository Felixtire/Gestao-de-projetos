package com.gestao.api.api.domain.dto.project;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosParaCriarProjeto(

        @NotBlank
        String name,
        String description,
        LocalDate startDate ,

        LocalDate endDate
) {
}
