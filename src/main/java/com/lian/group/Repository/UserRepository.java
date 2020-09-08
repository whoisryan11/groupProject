package com.lian.group.Repository;

import com.lian.group.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer userId);
    List<User> findAll();
}
