package com.lian.group.Entity;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void getId() {
        Project project = new Project();
        Integer id =1;
        project.setId(id);
        assert (project.getId() == 1);
    }

    @Test
    void setId() {
        Project project = new Project();
        project.setId(1);
        assert (project.getId() == 1);
    }

    @Test
    void getProjectName() {
        Project project = new Project();
        project.setProjectName("projectName");
        assert (project.getProjectName()).equals("projectName");
    }

    @Test
    void setProjectName() {
        Project project = new Project();
        project.setProjectName("projectName");
        assert (project.getProjectName()).equals("projectName");
    }

    @Test
    void getUser() {
        Project project = new Project();
        User user = new User();
        project.setUser(user);
        assert (project.getUser()).equals(project.getUser());
    }

    @Test
    void setUser() {
        Project project = new Project();
        User user = new User();
        project.setUser(user);
        assert (project.getUser()).equals(project.getUser());
    }

    @Test
    void getResources() {
        Project project = new Project();
        ProjectResource projectResource = new ProjectResource();
        Set<ProjectResource> resourceSet = new HashSet<ProjectResource>();
        resourceSet.add(projectResource);
        project.setResources(resourceSet);
        assert (project.getResources()).equals(project.getResources());
    }

    @Test
    void setResources() {
        Project project = new Project();
        ProjectResource projectResource = new ProjectResource();
        Set<ProjectResource> resourceSet = new HashSet<ProjectResource>();
        resourceSet.add(projectResource);
        project.setResources(resourceSet);
        assert (project.getResources()).equals(project.getResources());
    }
}