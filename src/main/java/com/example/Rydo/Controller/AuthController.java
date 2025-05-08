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
    public ResponseEntity<UserLoginDTO> LoginUser(@RequestBody UserLoginDTO Details) {
        UserLoginDTO user = authService.LoginUser(Details);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> CreateUser(@RequestBody UserRegisterDTO Details) {
        UserRegisterDTO user = authService.Register(Details);
        return ResponseEntity.ok(user);
    }
}
