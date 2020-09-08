package com.lian.group.Repository;

import com.lian.group.Entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    UserDetail findUserDetailById(Integer userDetailId);
}
