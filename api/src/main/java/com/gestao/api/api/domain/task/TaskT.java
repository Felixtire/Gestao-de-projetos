package com.gestao.api.api.domain.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestao.api.api.domain.dto.DadosParaCriarTask;
import com.gestao.api.api.domain.project.ProjectEntity;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Entity(name = "Task")
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TaskT {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String descriptionTask;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private ProjectEntity project;

    public TaskT(DadosParaCriarTask dados) {

        this.title= dados.title();
        this.descriptionTask = dados.description();
        this.status=dados.status();
        this.dueDate =dados.dueDate();
        this.priority=dados.priority();

        var pjRef = new ProjectEntity();
        pjRef.setId(dados.Idproject());
        this.project= pjRef;





    }
}
