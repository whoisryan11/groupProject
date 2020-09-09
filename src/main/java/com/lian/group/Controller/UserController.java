package com.lian.group.Controller;

import com.lian.group.Entity.User;
import com.lian.group.Service.UserService;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("getUser/uid={uid}")
    public User findUserByID (@PathVariable Integer uid) throws Exception {
        return userService.findOne(uid);
    }

    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("AssignUserDetail/uid={uid}&detail_id={detail_id}")
    public User AssignUserDetail (@PathVariable Integer uid,
                                  @PathVariable Integer detail_id ) throws Exception {
        return userService.assignDetail(uid, detail_id);
    }
}
