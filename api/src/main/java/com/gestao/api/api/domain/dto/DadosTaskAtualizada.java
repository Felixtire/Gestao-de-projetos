package com.gestao.api.api.domain.dto;

import com.gestao.api.api.domain.task.Status;
import com.gestao.api.api.domain.task.TaskT;

import java.time.LocalDate;

public record DadosTaskAtualizada(String title , String description, Status status) {

    public DadosTaskAtualizada(TaskT taskT){
        this(taskT.getTitle(),taskT.getDescriptionTask(),taskT.getStatus());
    }
}
