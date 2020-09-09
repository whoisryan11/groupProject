package com.lian.group.ServiceImpl;

import com.lian.group.Entity.User;
import com.lian.group.Entity.UserDetail;
import com.lian.group.Repository.UserDetailRepository;
import com.lian.group.Repository.UserRepository;
import com.lian.group.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
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
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        final Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", username)));

    }

    @Override
    public User updatePassword(Integer userId, String password) throws Exception {
        User userToUpdate = userRepository.findUserById(userId);
        if (userToUpdate == null) {
            throw new Exception("No User Found!!!");
        }
        userToUpdate.setPassword(password);
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    @Override
    public User assignDetail(Integer userId, Integer userDetailId) throws Exception {
        User userToUpdate = userRepository.findUserById(userId);
        UserDetail userDetail = userDetailRepository.findUserDetailById(userDetailId);
        if (userToUpdate == null) {
            throw new Exception("No User Found!!!");
        }
        if (userDetail == null) {
            throw new Exception("No User Found!!!");
        }
        userToUpdate.setUserDetail(userDetail);
        userRepository.save(userToUpdate);
        return userToUpdate;
    }


}
