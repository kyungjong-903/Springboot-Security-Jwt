package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
public class UserAuthentication implements UserDetails, Authentication {

    private String principal;
    private String credential;
    private User user;

    public UserAuthentication(String username, String password) {
        this.principal = username;
        this.credential = password;
    }

    public User getUser() {return this.user;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return this.credential;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    public Long getUserId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return this.credential;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isInvalid();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isInvalid();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isInvalid();
    }

    @Override
    public boolean isEnabled() {
        return !user.isInvalid();
    }

    @Override
    public String getName() {
        return null;
    }
}
