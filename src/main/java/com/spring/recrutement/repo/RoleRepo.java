package com.spring.recrutement.repo;

import com.spring.recrutement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role , Long> {


    Optional<Role> findRoleById(Long id);
    Optional<Role> findRoleByNom(String nom);

    void deleteRoleById(Long id);
}
