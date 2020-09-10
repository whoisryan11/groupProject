package com.lian.group.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectResourceTest {

    @Test
    void getId() {
        ProjectResource projectResource = new ProjectResource();
        Integer id =1;
        projectResource.setId(id);
        assert (projectResource.getId() == 1);
    }

    @Test
    void setId() {
        ProjectResource projectResource = new ProjectResource();
        projectResource.setId(1);
        assert (projectResource.getId() == 1);
    }

    @Test
    void getProject() {
        ProjectResource projectResource = new ProjectResource();
        Project project = new Project();
        projectResource.setProject(project);
        assert (projectResource.getProject()).equals(projectResource.getProject());
    }

    @Test
    void setProject() {
        ProjectResource projectResource = new ProjectResource();
        Project project = new Project();
        projectResource.setProject(project);
        assert (projectResource.getProject()).equals(projectResource.getProject());
    }

    @Test
    void getResource() {
        ProjectResource projectResource = new ProjectResource();
        Resource resource = new Resource();
        projectResource.setResource(resource);
        assert (projectResource.getResource()).equals(projectResource.getResource());
    }

    @Test
    void setResource() {
        ProjectResource projectResource = new ProjectResource();
        Resource resource = new Resource();
        projectResource.setResource(resource);
        assert (projectResource.getResource()).equals(projectResource.getResource());
    }
}