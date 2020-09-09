package com.lian.group.Controller;

import com.lian.group.Entity.Project;
import com.lian.group.Service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping("/addProject")
    public String addProject(@RequestParam String name) {
        projectService.addProject(name);
        return "Added new Project";
    }

    @GetMapping("/projects")
    public Iterable<Project> getProjects(){
        return projectService.findAll();
    }

    @GetMapping("project/{id}")
    public Project findProjectById (@PathVariable Integer id) throws Exception {
        return projectService.findOne(id);
    }
}
