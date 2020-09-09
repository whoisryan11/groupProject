package com.lian.group.ServiceImpl;

import com.lian.group.Entity.Resource;
import com.lian.group.Repository.ResourceRepository;
import com.lian.group.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findOne(Integer id) throws Exception {
        Resource resource = resourceRepository.findResourceById(id);
        if(resource == null){
            throw new Exception("NO Resource founded by id => "+id);
        }
        return resource;
    }

    @Override
    public List<Resource> findAll() {
        List<Resource> list = resourceRepository.findAll();
        return list;
    }
}
