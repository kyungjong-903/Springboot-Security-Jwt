package com.example.demo.controller;

import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.LoginService;
import com.example.demo.util.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;

    @GetMapping()
    public String getAuth() {
        return "Auth";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        boolean authLogin = StringUtil.hasValue(request.getUsername()) && StringUtil.hasValue(request.getPassword());
        return null;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRequest request) {

        String token = loginService.register(request);

        return null;
    }
}
