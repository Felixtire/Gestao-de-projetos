package com.gestao.api.api.domain.dto.project;

import com.gestao.api.api.domain.project.ProjectEntity;

import java.time.LocalDate;

public record DadosListagemProjeto(String name, String description, LocalDate startDate, LocalDate endDate) {

    public DadosListagemProjeto(ProjectEntity entity){
        this(entity.getName(),entity.getDescription(),entity.getStartDate(),entity.getEndDate());
    }



}
