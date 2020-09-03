package com.lian.group.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @Column(name = "role")
    private String role;

    @Column(name = "user_image")
    private String image_url;

    public UserDetail() {

    }

    public UserDetail(User user){
        this.id = user.getId();
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
