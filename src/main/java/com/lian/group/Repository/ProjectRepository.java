package com.lian.group.Repository;

import com.lian.group.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findProjectById(Integer projectId);

    Project findProjectByUserId(Integer userId);

    String deleteProjectById(Integer projectId);
}
