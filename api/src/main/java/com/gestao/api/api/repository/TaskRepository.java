package com.gestao.api.api.repository;

import com.gestao.api.api.domain.task.TaskT;
import com.gestao.api.api.domain.task.enu.Priority;
import com.gestao.api.api.domain.task.enu.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskT, Long> {
    List<TaskT> findByStatus(Status status);

    List<TaskT> findByPriority(Priority priority);

    List<TaskT> findByPriorityAndStatus(Priority priority,Status status);
}
