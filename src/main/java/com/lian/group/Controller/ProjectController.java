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
    public String addProject(@RequestParam String name) { return projectRepository.addProject(name); }

    @GetMapping("/project")
    public Iterable<Project> getProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("project/{id}")
    public Project findProjectById (@PathVariable Integer id) {
        return projectRepository.findProjectById(id);
    }

    @DeleteMapping("/project/{id}")
    public String deleteProjectById(@PathVariable Integer id) { return projectRepository.deleteProjectById(id); }
}
