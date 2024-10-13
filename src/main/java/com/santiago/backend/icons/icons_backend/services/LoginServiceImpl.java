package com.santiago.backend.icons.icons_backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santiago.backend.icons.icons_backend.entities.UserEntity;
import com.santiago.backend.icons.icons_backend.models.LoginRequest;
import com.santiago.backend.icons.icons_backend.repositories.UsersRepository;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public ResponseEntity<?> validateCredentials(LoginRequest loginRequest) {

        if(loginRequest.getUsername() == null || loginRequest.getUsername() == ""){
            return ResponseEntity.badRequest().body("Por favor ingrese el email");
        }else if(loginRequest.getPassword() == null || loginRequest.getPassword() == ""){
            return ResponseEntity.badRequest().body("Por favor ingrese la contraseña");
        }

        UserEntity userDb = usersRepository.validateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if(userDb != null){
            return ResponseEntity.ok().body(userDb);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe, por favor registrese o intente con un usuario y contraseña diferentes");

    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return usersRepository.save(user);
    }



}
