package com.santiago.backend.icons.icons_backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.santiago.backend.icons.icons_backend.entities.UserEntity;


public interface UserService {

    List<UserEntity> getAllUsers();
    ResponseEntity<?> getUser(Long id);

}
