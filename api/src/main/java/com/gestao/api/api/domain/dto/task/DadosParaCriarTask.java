package com.gestao.api.api.domain.dto.task;

import com.gestao.api.api.domain.task.Priority;
import com.gestao.api.api.domain.task.Status;

import java.time.LocalDate;

public record DadosParaCriarTask(Long Idproject, String title,String description ,Status status, Priority priority, LocalDate dueDate) {
}
