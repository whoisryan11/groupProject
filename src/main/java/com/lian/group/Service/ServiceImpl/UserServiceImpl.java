package com.lian.group.Service.ServiceImpl;

import com.lian.group.Entity.User;
import com.lian.group.Entity.UserDetail;
import com.lian.group.Repository.UserDetailRepository;
import com.lian.group.Repository.UserRepository;
import com.lian.group.Security.CreateUserRequest;
import com.lian.group.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public User updatePassword(Integer userId, String password) throws Exception {
        User userToUpdate = userRepository.findUserById(userId);
        if (userToUpdate == null) {
            throw new Exception("No User Found!!!");
        }
        userToUpdate.setPassword(passwordEncoder.encode(password));
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

    @Override
    public User createUser(CreateUserRequest user) throws Exception {
        User newUser = new User();
        UserDetail detail = new UserDetail();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        userRepository.saveAndFlush(newUser);

        detail.setUserRoleRegisterDate(new Date());
        userDetailRepository.save(detail);

        newUser.setUserDetail(detail);
        userRepository.saveAndFlush(newUser);
        return newUser;
    }

    @Override
    public User createUser(String username, String password, String email,
                           String image, String role) throws Exception {
        // Check if the parameters are empty
        if (username == null) { throw new Exception("Empty username"); }
        else if (password == null) { throw new Exception("Empty password");}

        // Create User
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setEmail(email);
        userRepository.saveAndFlush(newUser);
        // Create UserDetail
        UserDetail detail = new UserDetail();
        detail.setImage_url(image);
        detail.setRole(role);
        detail.setUserRoleRegisterDate(new Date());
        userDetailRepository.save(detail);
        //newUser.setUserDetail(detail);
        // Save User
        newUser.setUserDetail(detail);
        userRepository.saveAndFlush(newUser);
        return newUser;
    }

    @Override
    public User updateEmail(Integer userId, String newEmail) throws Exception {
        User userToUpdate = userRepository.findUserById(userId);
        if (userToUpdate == null) {
            throw new Exception("No Such User Found!!!");
        }
        userToUpdate.setEmail(newEmail);
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    @Override
    public User updateUserImage(Integer userId, String newImg) throws Exception {
        User userToUpdate = userRepository.findUserById(userId);
        if (userToUpdate == null) {
            throw new Exception("No Such User Found!!!");
        }
        UserDetail userDetail = userToUpdate.getUserDetail();
        if(userDetail == null) {
            userDetail = new UserDetail();
            userDetail.setImage_url(newImg);
            userToUpdate.setUserDetail(userDetail);
            userRepository.save(userToUpdate);
        } else {
            userDetail.setImage_url(newImg);
        }
        userDetailRepository.save(userDetail);
        return userToUpdate;
    }

    @Override
    public User updateRole(Integer userId, String newRole) throws Exception {
        User userToUpdate = userRepository.findUserById(userId);
        if (userToUpdate == null) {
            throw new Exception("No Such User Found!!!");
        }
        UserDetail userDetail = userToUpdate.getUserDetail();
        if(userDetail == null) {
            userDetail = new UserDetail();
            userDetail.setRole(newRole);
            userToUpdate.setUserDetail(userDetail);
            userRepository.save(userToUpdate);
        } else {
            userDetail.setRole(newRole);
        }
        userDetailRepository.save(userDetail);
        return userToUpdate;

    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }


}
