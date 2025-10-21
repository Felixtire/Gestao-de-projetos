package com.gestao.api.api.repository;

import com.gestao.api.api.domain.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {

}
