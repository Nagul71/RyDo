package com.example.Rydo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rydo.Dtos.UserLoginDTO;
import com.example.Rydo.Dtos.UserRegisterDTO;
import com.example.Rydo.Service.AuthService;


@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody UserLoginDTO details) {
        return authService.LoginUser(details);
    }

    @PostMapping("/register")
    public ResponseEntity<?> CreateUser(@RequestBody UserRegisterDTO details) {
        return authService.CreateUser(details);
    }
}
