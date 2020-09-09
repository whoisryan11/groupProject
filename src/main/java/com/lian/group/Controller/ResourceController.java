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

    // what is @pathVar ==> use to refer {id} in url
    @GetMapping("/getResource/{id}")
    public Resource findResourceByID(@PathVariable Integer id) throws Exception {
        return resourceService.findOne(id);
    }

    @GetMapping("/getResources")
    public List<Resource> getResources() {
        return resourceService.findAll();
    }

    // delete should use @GetMapping, Because the method use Http GET
    // @DeleteMapping Doesn't work???
    //    @DeleteMapping("/deleteResource/{id}")
    @GetMapping("/deleteResource/{id}")
    public String deleteResourceByID(@PathVariable Integer id) throws Exception {
        resourceService.deleteOne(id);
        return "Delete Successfully";
    }

    //Add
    @GetMapping("/addResource/{id}&{resourceName}")
    public String addResource(@PathVariable Integer id,@PathVariable String resourceName) throws Exception{
        resourceService.addOne(id,resourceName);
        return "Add Successfully";
    }
}
