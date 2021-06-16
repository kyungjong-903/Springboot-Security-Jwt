package com.example.demo.service;

import com.example.demo.config.CustomAuthenticationProvider;
import com.example.demo.config.TokenProvider;
import com.example.demo.config.UserAuthentication;
import com.example.demo.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final CustomAuthenticationProvider authenticationProvider;
    private final TokenProvider tokenProvider;


    public String login(LoginRequest request) {

        UserAuthentication auth = (UserAuthentication)authenticationProvider.authenticate(new UserAuthentication(request.getUsername(), request.getPassword()));

        return tokenProvider.generateToken(auth);

    }
}
