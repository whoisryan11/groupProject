package com.lian.group.Service;

import com.lian.group.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService  {
    // Find user by user id
    User findOne(Integer userId) throws Exception;

    // Find all the users
    List<User> findAll();

    // Update password
    User updatePassword(Integer userId, String password) throws Exception;

    // Assign user to the user detail
    User assignDetail(Integer userId, Integer userDetailId) throws Exception;

    User createUser(String username, String password, String email, String image, String role) throws Exception;

    //Update Email
    User updateEmail(Integer userId, String newEmail) throws Exception;

    //Update image
    User updateUserImage(Integer userId, String newImg) throws Exception;

    //Update role
    User updateRole(Integer userId, String newRole) throws Exception;
}
