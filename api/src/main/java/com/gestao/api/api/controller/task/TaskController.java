package com.gestao.api.api.controller.task;

import com.gestao.api.api.domain.dto.task.DadosParaCriarTask;
import com.gestao.api.api.domain.dto.task.DadosTaskAtualizada;
import com.gestao.api.api.domain.dto.task.DadosTaskCriada;
import com.gestao.api.api.domain.task.enu.Priority;
import com.gestao.api.api.domain.task.enu.Status;
import com.gestao.api.api.service.task.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("{id}/{status}")
    @Transactional
    public ResponseEntity uptadateTask(@PathVariable Long id, @PathVariable Status status){

        var update = service.updateTask(id, status);

        return ResponseEntity.ok().body(new DadosTaskAtualizada(update));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }



}
