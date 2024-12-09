package com.example.controller;

import com.example.exceptions.MyExceptions;
import com.example.request.LoginRequest;
import com.example.security.MyTokenManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/auth/")
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class AuthController {


    private final MyTokenManager jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<String> login(@Valid
                                        @RequestBody LoginRequest loginRequest,
                                        BindingResult br) {
        if (br.hasErrors()) {
            throw new MyExceptions("Məlumatlar düzgün daxil edilməyib", br);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword())
        );
        String username = authentication.getName();
        String token = jwtTokenProvider.generateToken(username);
        return ResponseEntity.ok(token);
    }
}
