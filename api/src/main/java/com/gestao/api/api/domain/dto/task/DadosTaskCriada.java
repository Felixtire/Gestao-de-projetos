package com.gestao.api.api.domain.dto.task;

import com.gestao.api.api.domain.task.TaskT;

import java.time.LocalDate;

public record DadosTaskCriada( String title , String description, LocalDate dueDate) {

    public DadosTaskCriada(TaskT taskT) {
        this(taskT.getTitle(), taskT.getDescriptionTask(), taskT.getDueDate());
    }

}
