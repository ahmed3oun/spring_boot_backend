package com.spring.recrutement.Service;

import com.spring.recrutement.config.MyUserDetails;
import com.spring.recrutement.repo.UserRepo;
import com.spring.recrutement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AuthUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepo userRepo ;

    public AuthUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

      //  return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),  new ArrayList<>());
        return new com.spring.recrutement.config.MyUserDetails(user);

    }

}
