package com.lian.group.ServiceImpl;

import com.lian.group.Entity.Project;
import com.lian.group.Entity.ProjectResource;
import com.lian.group.Entity.Resource;
import com.lian.group.Repository.ProjectRepository;
import com.lian.group.Repository.ResourceRepository;
import com.lian.group.Repository.ProjectResourceRepository;
import com.lian.group.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public Project findOne(Integer projectId) throws Exception {
        Project project = projectRepository.findProjectById(projectId);
        if (project == null) {
            throw new Exception("No Project Found!!!");
        }
        return project;
    }

    @Override
    public List<Project> findAll() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

    @Override
    public String addProject (String projectName){
        Project project = new Project();
        project.setProjectName(projectName);
        projectRepository.save(project);
        return "Added new project to repo!";
    }

    public String addResource(Integer projectResourceId, Integer projectId, Integer resourceId) throws Exception{
        Project project = projectRepository.findProjectById(projectId);
        Resource resource = resourceRepository.findResourceById(resourceId);
        ProjectResource projectResource = projectResourceRepository.findProjectResourceById(projectResourceId);
        if(project == null){
            throw new Exception("No project found");
        }
        if(resource == null){
            throw new Exception("No resource found");
        }
        if(projectResource == null) {
            throw new Exception("No projectResource found");
        }
        projectResource.setProject(project);
        projectResource.setResource(resource);
        projectResourceRepository.save(projectResource);

        return "Project and Resource saved in ProjectRepo!!";
    }

    @Override
    public String deleteProjectById(Integer projectId) throws Exception {
        Project project = projectRepository.findProjectById(projectId);
        if(project == null){
            throw new Exception("No project found");
        }
        projectRepository.deleteProjectById(projectId);
        return "Removed project";
    }
}
