package com.lian.group.Service;

import com.lian.group.Entity.Resource;

import java.util.List;

public interface ResourceService {
    Resource findOne(Integer id) throws Exception;
    List<Resource> findAll();
    void deleteOne(Integer id) throws Exception;
}
