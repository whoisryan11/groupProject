package com.lian.group.Service;

import com.lian.group.Entity.User;

public interface UserService {
    User findOne(Integer userId) throws Exception;
}
