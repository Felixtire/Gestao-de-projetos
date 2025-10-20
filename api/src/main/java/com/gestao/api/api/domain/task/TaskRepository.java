package com.gestao.api.api.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskT, Long> {
    List<TaskT> findByStatus(Status status);

    List<TaskT> findByPriority(Priority priority);

    List<TaskT> findByPriorityAndStatus(Priority priority,Status status);
}
