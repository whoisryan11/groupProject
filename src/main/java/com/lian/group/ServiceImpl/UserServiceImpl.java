package com.lian.group.ServiceImpl;

import com.lian.group.Entity.User;
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

    @Override
    public User registerNewUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        final Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", username)));

    }
}
