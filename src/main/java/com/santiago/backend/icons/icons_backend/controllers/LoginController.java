package com.santiago.backend.icons.icons_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.backend.icons.icons_backend.entities.UserEntity;
import com.santiago.backend.icons.icons_backend.models.LoginRequest;
import com.santiago.backend.icons.icons_backend.services.LoginServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/icons")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

       return loginService.validateCredentials(loginRequest);

    }

    @PostMapping("/signUp")
    public UserEntity login(@RequestBody UserEntity user){
       return loginService.saveUser(user);

    }

}
