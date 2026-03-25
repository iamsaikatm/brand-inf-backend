package com.saikat.influencerapp.controller;

import com.saikat.influencerapp.dto.LoginRequest;
import com.saikat.influencerapp.dto.SignupRequest;
import com.saikat.influencerapp.entity.User;
import com.saikat.influencerapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}