package com.lian.group.Controller;

import com.lian.group.Entity.Resource;
import com.lian.group.Service.ResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Forget about this will get all stuff wrong
@SpringBootTest
class ResourceControllerTest {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceController resourceController;
    
    @Test
    public void contextLoads() throws Exception {
        assertNotNull(resourceController);
    }

    @Test
    void findResourceByID() throws Exception {
        Resource serviceR = resourceService.findOne(111);
        Resource controllerR = resourceController.findResourceByID(111);
//        System.out.println(serviceR);
        assertEquals(serviceR.getId(),controllerR.getId());
        assertEquals(serviceR.getName(),controllerR.getName());

    }

    @Test
    void findResourceByResourceName() throws Exception {
        Resource serviceR = resourceService.findName("test3");
        Resource controllerR = resourceController.findResourceByResourceName("test3");
        assertEquals(serviceR.getId(),controllerR.getId());
        assertEquals(serviceR.getName(),controllerR.getName());
    }

    @Test
    void getAllResources() {
        List<Resource> serviceAll = resourceService.findAll();
        List<Resource> controllerAll = resourceController.getAllResources();
        assertEquals(serviceAll.size(),controllerAll.size());
    }

//    @Test
//    void deleteResourceByID() throws Exception {
//        resourceController.deleteResourceByID(119);
//        assertNull(resourceService.findOne(119));
//    }

    @Test
    void addResource() throws Exception {
        //void .addResource
         resourceController.addResource("testADD2");
         Resource serviceR = resourceService.findName("testADD2");
         assertEquals(serviceR.getName(),"testADD2");

    }

    @Test
    void updateResource() throws Exception {
        resourceController.updateResource(111,"testUpdate2");
        Resource serviceR = resourceService.findOne(111);
        assertEquals(serviceR.getName(),"testUpdate2");
    }
}