package com.gestao.api.api.controller.project;

import com.gestao.api.api.domain.dto.project.DadosListagemProjeto;
import com.gestao.api.api.domain.dto.project.DadosParaCriarProjeto;
import com.gestao.api.api.domain.dto.project.DadosProjetoCriado;
import com.gestao.api.api.service.project.ProjectService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    @Transactional
    public ResponseEntity createProject(@RequestBody @Valid DadosParaCriarProjeto dadosParaCriarProjeto, UriComponentsBuilder uriComponentsBuilder) {

        var projeto=  service.createProject(dadosParaCriarProjeto);

        var uri = uriComponentsBuilder.path("/project/{id}").buildAndExpand(projeto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosProjetoCriado(projeto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProjeto>> listProjects(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(service.list(pageable));
    }


}
