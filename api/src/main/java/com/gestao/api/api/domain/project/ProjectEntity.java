package com.gestao.api.api.domain.project;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestao.api.api.domain.dto.project.DadosParaCriarProjeto;
import com.gestao.api.api.domain.task.TaskT;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Project")
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProjectEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskT> tasks;

    public ProjectEntity(DadosParaCriarProjeto dados) {
        this.name = dados.name();
        this.description = dados.description();
        this.startDate = dados.startDate();
        this.endDate = dados.endDate();

    }
}
