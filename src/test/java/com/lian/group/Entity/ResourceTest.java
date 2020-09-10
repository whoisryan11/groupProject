package com.lian.group.Entity;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class ResourceTest {

    @Test
    void getId() {
        Integer id = 1;;
        Resource resource = new Resource();
        resource.setId(id);
        assert (resource.getId()).equals(id);
    }

    @Test
    void setId() {
        Integer id = 1;;
        Resource resource = new Resource();
        resource.setId(id);
        assert (resource.getId()).equals(id);
    }

    @Test
    void getName() {
        String name = "name";
        Resource resource = new Resource();
        resource.setName(name);
        assert (resource.getName()).equals(name);
    }

    @Test
    void setName() {
        String name = "name";
        Resource resource = new Resource();
        resource.setName(name);
        assert (resource.getName()).equals(name);
    }

    @Test
    void getProjects() {
        Resource resource = new Resource();
        ProjectResource projectResource = new ProjectResource();
        Set<ProjectResource> projectSet = new HashSet<ProjectResource>();
        projectSet.add(projectResource);
        resource.setProjects(projectSet);
        assert (resource.getProjects()).equals(projectSet);
    }

    @Test
    void setProjects() {
        Resource resource = new Resource();
        ProjectResource projectResource = new ProjectResource();
        Set<ProjectResource> projectSet = new HashSet<ProjectResource>();
        projectSet.add(projectResource);
        resource.setProjects(projectSet);
        assert (resource.getProjects()).equals(projectSet);
    }
}