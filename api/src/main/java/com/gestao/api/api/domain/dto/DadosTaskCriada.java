package com.gestao.api.api.domain.dto;

import com.gestao.api.api.domain.project.ProjectEntity;
import com.gestao.api.api.domain.task.TaskT;

import java.time.LocalDate;
import java.util.Date;

public record DadosTaskCriada( String title , String description, LocalDate dueDate) {

    public DadosTaskCriada(TaskT taskT) {
        this(taskT.getTitle(), taskT.getDescriptionTask(), taskT.getDueDate());
    }

}
