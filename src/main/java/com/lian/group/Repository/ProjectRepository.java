package com.lian.group.Repository;

import com.lian.group.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findProjectById(Integer projectId);

    String addProject(String name);

    String deleteProjectById(Integer projectId);

}
