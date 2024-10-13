package com.santiago.backend.icons.icons_backend.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.santiago.backend.icons.icons_backend.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u where u.email=?1 AND u.password=?2")
    UserEntity validateUser(String username, String password);
    

}
