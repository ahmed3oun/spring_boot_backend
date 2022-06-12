package com.spring.recrutement.repo;

import com.spring.recrutement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>{
    
    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);

    User findByUsername(String username);
}
