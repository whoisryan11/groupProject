package com.lian.group.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_detail_id")
    private UserDetail userDetail;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    //@Builder.Default
    //private UserRole userRole = UserRole.USER;

    //@Builder.Default
    //private Boolean locked = false;

    //@Builder.Default
    //private Boolean enabled = false;

    @OneToMany(
            fetch=FetchType.LAZY,
            mappedBy = "user",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    Set<Project> projects;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public UserDetail getUserDetail() { return userDetail; }

    public void setUserDetail(UserDetail userDetail) { this.userDetail = userDetail; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
        return Collections.singletonList(simpleGrantedAuthority);
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
