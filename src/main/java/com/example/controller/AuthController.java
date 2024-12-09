package com.example.controller;

import com.example.request.LoginRequest;
import com.example.security.MyTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/auth/")
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class AuthController {


    private final MyTokenManager tokenManager;
    private final AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword())
        );
        String username = authentication.getName();
        String token = tokenManager.generateToken(username);
        return ResponseEntity.ok(token);
    }
}
