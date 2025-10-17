package com.gestao.api.api.domain.dto;

import com.gestao.api.api.domain.project.ProjectEntity;

import java.util.Date;

public record DadosProjetoCriado(String name, String description, Date startDate) {

    public DadosProjetoCriado(ProjectEntity entity){
        this(entity.getName(), entity.getDescription(),entity.getStartDate());
    }
}
