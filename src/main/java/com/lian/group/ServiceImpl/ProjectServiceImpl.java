package com.lian.group.ServiceImpl;

import com.lian.group.Entity.Project;
import com.lian.group.Repository.ProjectRepository;
import com.lian.group.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
