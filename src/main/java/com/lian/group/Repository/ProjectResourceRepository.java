package com.lian.group.Repository;

import com.lian.group.Entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {
    ProjectResource findProjectResourceById(Integer id);
}
