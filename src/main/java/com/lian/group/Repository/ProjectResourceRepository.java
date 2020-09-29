package com.lian.group.Repository;

import com.lian.group.Entity.Project;
import com.lian.group.Entity.ProjectResource;
import com.lian.group.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {
    ProjectResource findProjectResourceById(Integer id);
    ProjectResource findProjectResourceByProjectAndResource(Project project, Resource resource);
}
