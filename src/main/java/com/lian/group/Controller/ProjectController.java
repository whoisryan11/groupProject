package com.lian.group.Controller;

import com.lian.group.Entity.Project;
import com.lian.group.Service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addProject")
    public ResponseEntity<String> addProject(@RequestParam String name) {
        projectService.addProject(name);
        return new ResponseEntity<>("Added new Project" + name, HttpStatus.OK);
    }

    @PostMapping("/addResource/")
    public ResponseEntity<String> addResource(@RequestParam Integer projectResourceId, @RequestParam Integer projectId, @RequestParam Integer resourceId) throws Exception {
        projectService.addResource(projectResourceId, projectId, resourceId);
        return new ResponseEntity<>("Added Resource to Project" + resourceId, HttpStatus.OK);
    }

    @PutMapping("/updateProject/")
    public ResponseEntity<Project> updateProject(@RequestParam Integer projectId, @RequestParam String name) throws Exception {
        return new ResponseEntity<>(projectService.updateProject(projectId, name), HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<Iterable<Project>> getProjects(){
        Iterable<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @DeleteMapping("/projectDeleteResource")
    public ResponseEntity<String> projectDeleteResource(@RequestParam Integer project_id, @RequestParam Integer resource_id){
        return new ResponseEntity<>(projectService.deleteResourceFromProject(project_id, resource_id), HttpStatus.OK);
    }

    @GetMapping("/project/")
    public ResponseEntity<Project> findProjectById (@RequestParam Integer id) throws Exception {
        return new ResponseEntity<>(projectService.findOne(id), HttpStatus.OK);
    }
}
