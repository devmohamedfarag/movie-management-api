package com.movie.movieapi.controller;

import com.movie.movieapi.Security.AuthService;
import com.movie.movieapi.dto.LoginDto.LoginRequest;
import com.movie.movieapi.dto.LoginDto.LoginResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        var encoder = new BCryptPasswordEncoder();
        var h = encoder.encode("admin123");
        boolean x = encoder.matches("admin123", "$2a$10$wgR6ehGWSt62ZkCL/wli.OqdVIGUdAWHs6ThC5jSmdYuEUUpq.Kue");
        return ResponseEntity.ok(authService.login(request));
    }
}
