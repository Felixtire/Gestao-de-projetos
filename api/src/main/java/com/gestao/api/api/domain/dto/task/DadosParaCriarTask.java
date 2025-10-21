package com.gestao.api.api.domain.dto.task;

import com.gestao.api.api.domain.task.enu.Priority;
import com.gestao.api.api.domain.task.enu.Status;

import java.time.LocalDate;

public record DadosParaCriarTask(Long Idproject, String title,String description ,Status status, Priority priority, LocalDate dueDate) {
}
