package com.saikat.influencerapp.service;

import com.saikat.influencerapp.dto.LoginRequest;
import com.saikat.influencerapp.dto.SignupRequest;
import com.saikat.influencerapp.entity.User;
import com.saikat.influencerapp.exception.AuthException;
import com.saikat.influencerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User signup(SignupRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    public User login(LoginRequest request) {

        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            throw new AuthException("User not found");
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(request.getPassword())) {
            throw new AuthException("Invalid password");
        }

        return user;
    }
}