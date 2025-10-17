package com.gestao.api.api.domain.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestao.api.api.domain.project.ProjectEntity;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity(name = "Task")
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TaskT {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    private String title;
    private String descriptionTask;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date dueDate;


    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

}
