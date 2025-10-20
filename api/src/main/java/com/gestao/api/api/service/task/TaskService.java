package com.gestao.api.api.service.task;

import com.gestao.api.api.domain.dto.DadosParaCriarTask;
import com.gestao.api.api.domain.project.ProjectRepository;
import com.gestao.api.api.domain.task.Priority;
import com.gestao.api.api.domain.task.Status;
import com.gestao.api.api.domain.task.TaskRepository;
import com.gestao.api.api.domain.task.TaskT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public TaskT createTask(DadosParaCriarTask dados){
        var project = projectRepository.findById(dados.Idproject())
                .orElseThrow(()-> new RuntimeException("Projeto não encontrado"));


        var task = new TaskT(dados);

        return taskRepository.save(task);

    }

    public TaskT listForIdTask(Long id){
        if(id == null){
            return null;
        }

        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada ou não existe"));
    }

    public List<TaskT> list(Status status, Priority priority, Long id){
        if (id != null){
            return List.of(listForIdTask(id));
        }
        if (priority != null && status != null){
            return taskRepository.findByPriorityAndStatus(priority, status);
        }
        if (status != null){
            return taskRepository.findByStatus(status);
        }
        if (priority != null){
            return taskRepository.findByPriority(priority);
        }

        return taskRepository.findAll();
    }

    public TaskT updateTask(Long id, Status status){
        var task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Tarefa não encontrada"));
        task.setStatus(status);
        taskRepository.save(task);

        return task;

    }
    public String deleteTask(Long id){
        var task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Tarefa não encontrada"));
        taskRepository.deleteById(task.getId());

        return "Tarefa excluida com sucesso";
    }
}
