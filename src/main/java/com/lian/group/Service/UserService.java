package com.lian.group.Service;

import com.lian.group.Entity.User;

import java.util.List;

public interface UserService {
    User findOne(Integer userId) throws Exception;
    List<User> findAll();
}
