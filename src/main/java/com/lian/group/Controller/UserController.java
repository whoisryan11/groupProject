package com.lian.group.Controller;

import com.lian.group.Entity.User;
import com.lian.group.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/uid={id}")
    public User findUserByID (@PathVariable Integer id) throws Exception {

        return userService.findOne(id);
    }
}
