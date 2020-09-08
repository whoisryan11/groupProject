package com.lian.group.Controller;

import com.lian.group.Entity.Project;
import com.lian.group.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/addProject")
    public String addItem(@RequestParam String name) {
        Project project = new Project();
        project.setProjectName(name);
        projectRepository.save(project);
        return "Added new project to repo!";
    }

    @GetMapping("/project")
    public Iterable<Project> getProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("project/{id}")
    public Project findProjectById (@PathVariable Integer id) {
        return projectRepository.findProjectById(id);
    }
}
