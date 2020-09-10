package com.lian.group.Entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailTest {

    @Test
    void getId() {
        UserDetail detail = new UserDetail();
        Integer id = 1;
        detail.setId(id);
        assertEquals(detail.getId(), id);
    }

    @Test
    void setId() {
        UserDetail detail = new UserDetail();
        Integer id = 1;
        detail.setId(id);
        assertEquals(detail.getId(), id);
    }

    @Test
    void getRole() {
        UserDetail detail = new UserDetail();
        String role = "Manager";
        detail.setRole(role);
        assertEquals(detail.getRole(), role);
    }

    @Test
    void setRole() {
        UserDetail detail = new UserDetail();
        String role = "Manager";
        detail.setRole(role);
        assertEquals(detail.getRole(), role);
    }

    @Test
    void getImage_url() {
        UserDetail detail = new UserDetail();
        String url = "url";
        detail.setImage_url(url);
        assertEquals(detail.getImage_url(), url);
    }

    @Test
    void setImage_url() {
        UserDetail detail = new UserDetail();
        String url = "url";
        detail.setImage_url(url);
        assertEquals(detail.getImage_url(), url);
    }

    @Test
    void getUserRoleRegisterDate() {
        UserDetail detail = new UserDetail();
        Date date = new Date();
        detail.setUserRoleRegisterDate(date);
        assertEquals(detail.getUserRoleRegisterDate(), date);

    }

    @Test
    void setUserRoleRegisterDate() {
        UserDetail detail = new UserDetail();
        Date date = new Date();
        detail.setUserRoleRegisterDate(date);
        assertEquals(detail.getUserRoleRegisterDate(), date);
    }
}