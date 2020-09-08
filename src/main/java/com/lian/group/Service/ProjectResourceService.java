package com.lian.group.Service;

import com.lian.group.Entity.ProjectResource;

public interface ProjectResourceService {
    ProjectResource findOne(Integer projectResourceId) throws Exception;
}