package com.gestao.api.api.service.project;

import com.gestao.api.api.domain.dto.project.DadosListagemProjeto;
import com.gestao.api.api.domain.dto.project.DadosParaCriarProjeto;
import com.gestao.api.api.domain.project.ProjectEntity;
import com.gestao.api.api.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Transactional
    public ProjectEntity createProject(DadosParaCriarProjeto dados){

        var project = new ProjectEntity(dados);

        return repository.save(project);
    }

    public Page<DadosListagemProjeto> list(Pageable page){
       Page<ProjectEntity> pagina= repository.findAll(page);
       return pagina.map(DadosListagemProjeto::new);

    }
}
