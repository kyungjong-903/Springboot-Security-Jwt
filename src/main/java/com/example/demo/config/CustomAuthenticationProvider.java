package com.example.demo.config;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserAuthentication auth = (UserAuthentication) userDetailsService.loadUserByUsername(username);
        if(!passwordEncoder.matches(password, auth.getCredential())) System.out.println("에러");
        auth.setAuthenticated(true);
        return auth;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
