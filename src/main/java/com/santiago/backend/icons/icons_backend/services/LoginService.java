package com.santiago.backend.icons.icons_backend.services;

import org.springframework.http.ResponseEntity;

import com.santiago.backend.icons.icons_backend.entities.UserEntity;
import com.santiago.backend.icons.icons_backend.models.LoginRequest;


public interface LoginService {

    ResponseEntity<?> validateCredentials(LoginRequest loginRequest);
    UserEntity saveUser(UserEntity user);


}
