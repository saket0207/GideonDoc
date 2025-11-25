package com.document.gideon.controller;

import com.document.gideon.dto.LoginRequest;
import com.document.gideon.dto.RegisterRequest;
import com.document.gideon.entity.User;
import com.document.gideon.respository.UserRepository;
import com.document.gideon.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        userService.register(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        if (auth == null) return ResponseEntity.status(401).body("Not authenticated");
        return ResponseEntity.ok(auth.getName());
    }


}
