package com.lian.group.Repository;

import com.lian.group.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer userId);
    Optional<User> findByUsername(String username);
    List<User> findAll();

}
