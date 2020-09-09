package com.lian.group.Service;

import com.lian.group.Entity.Project;

import java.util.List;

public interface ProjectService {
    Project findOne(Integer projectId) throws Exception;
    List<Project> findAll();
    String addProject(String projectName);
    String deleteProjectById(Integer projectId) throws Exception;
    String addResource(Integer projectResourceId, Integer projectId, Integer resourceId) throws Exception;
}
