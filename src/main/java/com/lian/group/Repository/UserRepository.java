package com.lian.group.Repository;

import com.lian.group.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer userId);
    Optional<User> findByUsername(String username);
    List<User> findAll();
}
