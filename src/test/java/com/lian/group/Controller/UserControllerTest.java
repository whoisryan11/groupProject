package com.lian.group.Controller;

import com.lian.group.Entity.User;
import com.lian.group.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserController controller;

    @Autowired
    private UserService service;

    @Test
    public void contexLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    void getUsers() {
        List<User> serviceUser = service.findAll();
        List<User> users = controller.getUsers();
        //assertNotNull(users);
        assertEquals(users.size(), serviceUser.size());
    }
}