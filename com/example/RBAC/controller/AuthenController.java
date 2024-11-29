package com.example.RBAC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RBAC.entity.User;
import com.example.RBAC.repository.UserRepository;
import com.example.RBAC.service.AuthenticationService;
import com.example.RBAC.service.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthenController {
	
	
	   private final UserRepository userRepository;
	    private final JWTService jwtService;
	    private final AuthenticationService authenticationService;
	    private final PasswordEncoder passwordEncoder; // Changed to PasswordEncoder

	    public AuthenController(UserRepository userRepository, JWTService jwtService, AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.jwtService = jwtService;
	        this.authenticationService = authenticationService;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword())); // Use PasswordEncoder
	        userRepository.save(user);
	        return ResponseEntity.ok("User registered successfully!");
	    }
	}
	
