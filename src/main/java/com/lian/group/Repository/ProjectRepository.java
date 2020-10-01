package com.lian.group.Repository;

import com.lian.group.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findProjectById(Integer projectId);

    List<Project> findProjectByUserId(Integer userId);

    String deleteProjectById(Integer projectId);
}
