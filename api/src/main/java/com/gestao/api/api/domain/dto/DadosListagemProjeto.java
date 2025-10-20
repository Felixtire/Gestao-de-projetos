package com.gestao.api.api.domain.dto;

import com.gestao.api.api.domain.project.ProjectEntity;

import java.time.LocalDate;
import java.util.Date;

public record DadosListagemProjeto(String name, String description, LocalDate startDate, LocalDate endDate) {

    public DadosListagemProjeto(ProjectEntity entity){
        this(entity.getName(),entity.getDescription(),entity.getStartDate(),entity.getEndDate());
    }



}
