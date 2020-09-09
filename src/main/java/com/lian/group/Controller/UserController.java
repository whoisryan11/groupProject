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
        /**
         * Used for Updating plain text password to Bcrypt password in the database
         * 1. Change the type Password column to binary(60)
         * 2. Call the userService.updatePassword(uid, password) here
         * 3. Once password is set comment out this line and you can login with updated password*/
        //userService.updatePassword(100, "password1");
        return String.format("Hello %s!", name);
    }


    @GetMapping("getUser")
    public String findUserByID (@RequestParam Integer uid) throws Exception {
        User user = userService.findOne(uid);
        return String.format("GETTING User: %s!", user.getUsername());
    }

    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam Integer uid,
                                 @RequestParam String pwd) throws Exception {
        User user = userService.updatePassword(uid, pwd);
        return "Password Updated";
    }

    @PostMapping("/assignUserDetail")
    public String assignUserDetail(@RequestParam Integer uid,
                                 @RequestParam Integer detail_id) throws Exception {
        userService.assignDetail(uid, detail_id);
        return "User Detail Assigned";
    }

    @PostMapping("/createUser")
    public User createUser(@RequestParam String username,
                             @RequestParam String pwd,
                             @RequestParam String email,
                             @RequestParam String img,
                             @RequestParam String role) throws Exception {
        User newUser = userService.createUser(username, pwd, email, img, role);
        return newUser;
    }

    @PostMapping("/updateEmail")
    public String updateEmail(@RequestParam Integer uid,
                              @RequestParam String email) throws Exception {
        User user = userService.updateEmail(uid, email);
        return "Email Updated";
    }

    @PostMapping("/updateImg")
    public String updateImage(@RequestParam Integer uid,
                              @RequestParam String u_img) throws Exception {
        User user = userService.updateUserImage(uid, u_img);
        return "User's Image Updated";
    }

    @PostMapping("/updateRole")
    public String updateRole(@RequestParam Integer uid,
                             @RequestParam String role) throws Exception {
        User user = userService.updateRole(uid, role);
        return "User's Role Updated";
    }
}
