package com.lian.group.Controller;

import com.lian.group.Entity.User;
import com.lian.group.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


    @GetMapping("getUser/")
    public User findUserByID (@RequestParam(value = "uid", defaultValue = "100") Integer id) throws Exception {
        return userService.findOne(id);
    }

    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userService.findAll();
    }
}
