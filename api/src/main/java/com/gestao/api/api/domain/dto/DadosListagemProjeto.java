package com.gestao.api.api.domain.dto;

import com.gestao.api.api.domain.project.ProjectEntity;

import java.util.Date;

public record DadosListagemProjeto(String name, String description, Date startDate,Date endDate) {

    public DadosListagemProjeto(ProjectEntity entity){
        this(entity.getName(),entity.getDescription(),entity.getStartDate(),entity.getEndDate());
    }



}
