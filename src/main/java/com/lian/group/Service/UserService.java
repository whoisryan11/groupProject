package com.lian.group.Service;

import com.lian.group.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService  {
    User findOne(Integer userId) throws Exception;
    List<User> findAll();
    UserDetails loadUserByUsername(String username);
    User updatePassword(Integer userId, String password) throws Exception;
    User assignDetail(Integer userId, Integer userDetailId) throws Exception;
}
