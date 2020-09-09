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

    @PostMapping("/addResource/")
    public String addResource(@RequestParam Integer projectResourceId, @RequestParam Integer projectId, @RequestParam Integer resourceId) throws Exception {
        projectService.addResource(projectResourceId, projectId, resourceId);
        return "Added Resource to Project";
    }

    @GetMapping("/projects")
    public Iterable<Project> getProjects(){
        return projectService.findAll();
    }

    @GetMapping("project/")
    public Project findProjectById (@RequestParam Integer id) throws Exception {
        return projectService.findOne(id);
    }
}
