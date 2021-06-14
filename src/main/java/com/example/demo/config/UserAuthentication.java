package com.example.demo.config;

import com.example.demo.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserAuthentication implements UserDetails, Authentication {

    private String principal;
    private String credential;
    private User user;

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
        return user.getPassword();
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
