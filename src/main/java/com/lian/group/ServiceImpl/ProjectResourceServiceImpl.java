package com.lian.group.ServiceImpl;

import com.lian.group.Entity.ProjectResource;
import com.lian.group.Repository.ProjectResourceRepository;
import com.lian.group.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {
    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public ProjectResource findOne(Integer projectResourceId) throws Exception {
        ProjectResource projectResource = projectResourceRepository.findProjectResourceById(projectResourceId);
        if (projectResource == null) {
            throw new Exception("No ProjectResource Found!!!");
        }
        return projectResource;
    }
}
