package com.gestao.api.api.domain.dto;

import com.gestao.api.api.domain.project.ProjectEntity;
import com.gestao.api.api.domain.task.Priority;
import com.gestao.api.api.domain.task.Status;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public record DadosParaCriarTask(Long Idproject, String title,String description ,Status status, Priority priority, LocalDate dueDate) {
}
