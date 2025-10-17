package com.gestao.api.api.domain.project;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestao.api.api.domain.dto.DadosParaCriarProjeto;
import com.gestao.api.api.domain.task.TaskT;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.config.Task;

import java.text.Format;
import java.util.Date;
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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskT> tasks;

    public ProjectEntity(DadosParaCriarProjeto dados) {
        this.name = dados.name();
        this.description = dados.description();
        this.startDate = dados.startDate();
        this.endDate = dados.endDate();

    }
}
