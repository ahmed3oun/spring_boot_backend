package com.spring.recrutement.Service;

import com.spring.recrutement.exception.RoleNotFoundException;
import com.spring.recrutement.model.Role;
import com.spring.recrutement.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role addRole(Role role) {

        return roleRepo.save(role);
    }

    public List<Role> findAllRoles() {
        return roleRepo.findAll();
    }

    public Role updateRole(Role role) {
        return roleRepo.save(role);
    }

    public Role findRoleById(Long id) {
        return roleRepo.findRoleById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role by id " + id + " was not found"));
    }
    public Role findRoleByNom(String nom) {
        return roleRepo.findRoleByNom(nom)
                .orElseThrow(() -> new RoleNotFoundException("Role by nom " + nom + " was not found"));
    }

    public void deleteRole(Long id){
        roleRepo.deleteRoleById(id);
    }

}
