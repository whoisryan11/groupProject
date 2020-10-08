package com.lian.group.Service;

import com.lian.group.Entity.Resource;

import java.util.List;

public interface ResourceService {
    Resource findOne(Integer id) throws Exception;
    Resource findName(String resourceName) throws Exception;
    List<Resource> findAll();
    void deleteOne(Integer id) throws Exception;
    void addOne(String resourceName);
    void updateOne(Integer id,String resourceName)throws Exception;
    public void alterResourceAdd(String columnName,String columnType);
    public void alterResourceDrop(String columnName);
    public void truncateResource();
    public List getColumns();
}
