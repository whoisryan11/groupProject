package com.lian.group.Entity;

import org.junit.jupiter.api.Test;
class UserTest {


    @Test
    void getId() {
        User user = new User();
        Integer id =1;
        user.setId(id);
        assert (user.getId()).equals(1);
    }

    @Test
    void setId() {
        User user = new User();
        user.setId(1);
        assert (user.getId()).equals(1);
    }

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("myname");
        assert (user.getUsername()).equals("myname");
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("new Name");
        assert (user.getUsername()).equals("new Name");
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("1234");
        assert (user.getPassword()).equals("1234");
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("1234");
        assert (user.getPassword()).equals("1234");
    }

    @Test
    void getEmail() {
        User user = new User();
        user.setEmail("1234@g.com");
        assert (user.getEmail()).equals("1234@g.com");
    }

    @Test
    void setEmail() {
        User user = new User();
        user.setEmail("1234@g.com");
        assert (user.getEmail()).equals("1234@g.com");
    }

    @Test
    void getUserDetail() {
        User user = new User();
        UserDetail detail = new UserDetail();
        user.setUserDetail(detail);
        assert (user.getUserDetail()).equals(user.getUserDetail());
    }

    @Test
    void setUserDetail() {
        User user = new User();
        UserDetail detail = new UserDetail();
        user.setUserDetail(detail);
        assert (user.getUserDetail()).equals(user.getUserDetail());
    }
}