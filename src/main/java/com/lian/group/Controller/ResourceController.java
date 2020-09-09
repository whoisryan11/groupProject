package com.lian.group.Controller;

import com.lian.group.Entity.Resource;
import com.lian.group.Service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// what is a @restController?
@RestController
public class ResourceController {
    // All functions are using by Interface function, so you may imp it latter

    private final ResourceService resourceService;
    // initialize it
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    // what is @pathVar
    @GetMapping("/getResource/{id}")
    public Resource findResourceByID(@PathVariable Integer id) throws Exception{
        return resourceService.findOne(id);
    }

    @GetMapping("/getResources")
    public List<Resource> getResources(){
        return resourceService.findAll();
    }
}