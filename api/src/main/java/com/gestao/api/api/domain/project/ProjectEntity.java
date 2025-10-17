package com.gestao.api.api.domain.project;


import com.gestao.api.api.domain.dto.DadosParaCriarProjeto;
import com.gestao.api.api.domain.task.TaskT;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.config.Task;

import java.util.Date;

@Entity(name = "project")
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
    private Date startDate;
    private Date endDate;

    @Embedded
    private TaskT task;

    public ProjectEntity(DadosParaCriarProjeto dados) {
        this.name = dados.name();
        this.description = dados.description();
        this.startDate = dados.startDate();
        this.endDate = dados.endDate();

    }
}
