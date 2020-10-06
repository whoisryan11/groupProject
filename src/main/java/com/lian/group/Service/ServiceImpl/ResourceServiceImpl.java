package com.lian.group.Service.ServiceImpl;

import com.lian.group.Entity.Resource;
import com.lian.group.Repository.DatabaseUpdates;
import com.lian.group.Repository.ResourceRepository;
import com.lian.group.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private DatabaseUpdates databaseUpdates;

    // search by id
    @Override
    public Resource findOne(Integer id) throws Exception {
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null) {
            throw new Exception("NO Resource founded by id => " + id);
        }
        return resource;
    }

    @Override
    public Resource findName(String resourceName) throws Exception {
        Resource resource = resourceRepository.findResourceByName(resourceName);
        if (resource == null) {
            throw new Exception("NO Resource founded by resourceName => " + resourceName);
        }
        return resource;
    }

    // get all
    @Override
    public List<Resource> findAll() {
        List<Resource> list = resourceRepository.findAll();
        return list;
    }

    // delete by id
    @Override
    public void deleteOne(Integer id) throws Exception {
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null) {
            throw new Exception("Can't DELETE, NO Resource founded by id => " + id);
        }
        resourceRepository.deleteById(id);
    }

    @Override
    public void addOne(String resourceName) {

        Resource newTemp = new Resource(resourceName);
        resourceRepository.saveAndFlush(newTemp);

    }

    @Override
    public void updateOne(Integer id, String resourceName) throws Exception {
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null) {
            throw new Exception("Can't Update, The Resource Doesn't EXIST; id => " + id);
        } else {
            resource.setName(resourceName);
            resourceRepository.saveAndFlush(resource);
        }
    }

    //update database
    public void alterResourceAdd(String columnName,String columnType){
        //this
        databaseUpdates.alterResourceAddColumn(columnName,columnType);
    }

    public void alterResourceDrop(String columnName){
        databaseUpdates.alterResourceDropColumn(columnName);
    }

    public void truncateResource(){
        databaseUpdates.truncateResource();
    }
}
