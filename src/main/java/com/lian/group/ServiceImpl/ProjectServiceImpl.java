package com.lian.group.ServiceImpl;

import com.lian.group.Entity.Project;
import com.lian.group.Repository.ProjectRepository;
import com.lian.group.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project findOne(Integer projectId) throws Exception {
        Project project = projectRepository.findProjectById(projectId);
        if (project == null) {
            throw new Exception("No Project Found!!!");
        }
        return project;
    }

    public String addProject(String name) {
        Project project = new Project();
        project.setProjectName(name);
        projectRepository.save(project);
        return "Added new project to repo!";
    }

    public String deleteProjectById(Integer projectId) throws Exception {
        Project project = projectRepository.findProjectById(projectId);
        if (project == null) {
            throw new Exception("No Project Found!!!");
        }
        projectRepository.deleteProjectById(projectId);
        return "Removed project from repo!";
    }
}