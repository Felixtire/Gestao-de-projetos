package com.gestao.api.api.service.project;

import com.gestao.api.api.domain.dto.DadosParaCriarProjeto;
import com.gestao.api.api.domain.project.ProjectEntity;
import com.gestao.api.api.domain.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public ProjectEntity createProject(DadosParaCriarProjeto dados){

        var project = new ProjectEntity(dados);

        return repository.save(project);
    }
}
