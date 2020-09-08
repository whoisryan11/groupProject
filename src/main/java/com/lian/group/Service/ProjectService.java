package com.lian.group.Service;

import com.lian.group.Entity.Project;

public interface ProjectService {
    Project findOne(Integer projectId) throws Exception;

    String addProject(String projectName);

    String deleteProjectById(Integer projectId) throws Exception;
}