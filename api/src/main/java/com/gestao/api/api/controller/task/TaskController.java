package com.gestao.api.api.controller.task;

import com.gestao.api.api.domain.dto.DadosParaCriarTask;
import com.gestao.api.api.domain.dto.DadosTaskCriada;
import com.gestao.api.api.domain.task.Priority;
import com.gestao.api.api.domain.task.Status;
import com.gestao.api.api.service.task.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @Transactional
    public ResponseEntity createTaks(@RequestBody @Valid DadosParaCriarTask dados){

    var task =  service.createTask(dados);

    return ResponseEntity.ok().body(new DadosTaskCriada(task));
    //OLHAR A TABELA TASK O ID DO PROJETO N TA INDO ARRUMAR

    }

    @GetMapping
    public ResponseEntity listTask(@RequestParam(required = false) Status status,
                                   @RequestParam(required = false) Long id,
                                   @RequestParam(required = false) Priority priority){
        var result = service.list(status,priority,id);


        return ResponseEntity.ok().body(result);
    }



}
