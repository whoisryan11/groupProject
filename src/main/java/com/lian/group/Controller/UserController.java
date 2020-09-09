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


    @GetMapping("getUser/uid={uid}")
    public String findUserByID (@PathVariable Integer uid) throws Exception {
        User user = userService.findOne(uid);
        return String.format("GETTING User: %s!", user.getUsername());
    }

    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("updatePassword/uid={uid}&pwd={pwd}")
    public String updatePasword(@PathVariable Integer uid,
                                @PathVariable String pwd) throws Exception {
        User user = userService.updatePassword(uid, pwd);
        return "Password Updated";
    }

    @GetMapping("assignUserDetail/uid={uid}&detail_id={detail_id}")
    public User AssignUserDetail(@PathVariable Integer uid,
                                 @PathVariable Integer detail_id) throws Exception {
        return userService.assignDetail(uid, detail_id);
    }

    @GetMapping("createUser/username={username}&password={pwd}&email={email}&imgUrl={img}&role={role}")
    public User CreateUser(@PathVariable String username,
                             @PathVariable String pwd,
                             @PathVariable String email,
                             @PathVariable String img,
                             @PathVariable String role) throws Exception {
        User newUser = userService.createUser(username, pwd, email, img, role);
        return newUser;
    }
}
