package com.lian.group.ServiceImpl;

import com.lian.group.Entity.User;
import com.lian.group.Repository.UserDetailRepository;
import com.lian.group.Repository.UserRepository;
import com.lian.group.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public User findOne(Integer userId) throws Exception {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new Exception("No User Found!!!");
        }
        if(user.getUserDetail() != null){
            user.setUserDetail(null);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
