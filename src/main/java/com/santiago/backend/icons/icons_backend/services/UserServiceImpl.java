package com.santiago.backend.icons.icons_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santiago.backend.icons.icons_backend.entities.UserEntity;
import com.santiago.backend.icons.icons_backend.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) usersRepository.findAll();
        return users;
    }

    @Override
    public ResponseEntity<?> getUser(Long id) {
        Optional<UserEntity> userDb = usersRepository.findById(id);
        if(userDb.isPresent()){
            UserEntity user = userDb.orElseThrow();
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    

}
