package com.example.demo.controller;

import com.example.demo.config.UserAuthentication;
import com.example.demo.domain.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping()
    public String getAuth() {

        UserAuthentication auth = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();

        return auth.getUser().getName();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRequest request) {


        return null;
    }
}
