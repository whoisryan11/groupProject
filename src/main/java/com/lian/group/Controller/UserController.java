package com.lian.group.Controller;

import com.lian.group.Entity.User;
import com.lian.group.Security.AuthenticationRequest;
import com.lian.group.Security.AuthenticationResponse;
import com.lian.group.Security.MyUserDetailsService;
import com.lian.group.Service.UserService;
import com.lian.group.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            ));
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

/**
    @GetMapping("/")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
         * Used for Updating plain text password to Bcrypt password in the database
         * 1. Change the type Password column to binary(60)
         * 2. Call the userService.updatePassword(uid, password) here
         * 3. Once password is set comment out this line and you can login with updated password
        //userService.updatePassword(100, "password1");
        return String.format("Hello %s!", name);
    }
*/

    @GetMapping("getUser")
    public ResponseEntity<?> findUserByID (@RequestParam Integer uid) throws Exception {
        User user = userService.findOne(uid);
        return ResponseEntity.ok(user);
    }

    @GetMapping("getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("updatePassword")
    public ResponseEntity<?> updatePassword(@RequestParam Integer uid,
                                 @RequestParam String pwd) throws Exception {
        if(uid == null || userService.findOne(uid) == null){
            return ResponseEntity.badRequest().body("User not found");
        }
        User user = userService.updatePassword(uid, pwd);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/assignUserDetail")
    public ResponseEntity<?> assignUserDetail(@RequestParam Integer uid,
                                 @RequestParam Integer detail_id) throws Exception {
        User user = userService.assignDetail(uid, detail_id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestParam String username,
                             @RequestParam String pwd,
                             @RequestParam String email,
                             @RequestParam String img,
                             @RequestParam String role) throws Exception {
        User newUser = userService.createUser(username, pwd, email, img, role);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/updateEmail")
    public ResponseEntity<?> updateEmail(@RequestParam Integer uid,
                              @RequestParam String email) throws Exception {
        User user = userService.updateEmail(uid, email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/updateImg")
    public ResponseEntity<?> updateImage(@RequestParam Integer uid,
                              @RequestParam String u_img) throws Exception {
        User user = userService.updateUserImage(uid, u_img);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/updateRole")
    public ResponseEntity<?> updateRole(@RequestParam Integer uid,
                             @RequestParam String role) throws Exception {
        User user = userService.updateRole(uid, role);
        return ResponseEntity.ok(user);
    }
}
