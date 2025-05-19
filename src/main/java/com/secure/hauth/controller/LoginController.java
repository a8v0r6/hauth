package com.secure.hauth.controller;


import com.secure.hauth.dto.LoginUserDto;
import com.secure.hauth.dto.RegisterUserDto;
import com.secure.hauth.entity.UserModel;
import com.secure.hauth.response.LoginResponse;
import com.secure.hauth.service.AuthenticationService;
import com.secure.hauth.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
     private AuthenticationService authenticationService;

    @Autowired
    private JwtService jwtService;

    // signup user
    @PostMapping("/signup")
    public ResponseEntity<UUID> registerUser(@RequestBody RegisterUserDto input) {
        UUID id = authenticationService.signup(input);
        return ResponseEntity.ok(id);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto userDTO) {
        // Perform authentication logic
        // Return appropriate response or token
        UserModel authenticatedUser = authenticationService.authenticate(userDTO);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Perform logout logic
        // Invalidate token or session
        return ResponseEntity.ok("Logout successful");
    }
}
