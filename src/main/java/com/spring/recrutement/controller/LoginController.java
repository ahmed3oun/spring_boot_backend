package com.spring.recrutement.controller;

import com.spring.recrutement.Service.AuthUserDetailsService;
import com.spring.recrutement.config.MyUserDetails;
import com.spring.recrutement.model.User;
import com.spring.recrutement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthUserDetailsService auth ;

    @PostMapping("/login")
    public User generateToken(@RequestBody User user) throws Exception {
        MyUserDetails userDetails ;
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername() ,user.getPassword())) ;

            userDetails = (MyUserDetails) auth.loadUserByUsername(user.getUsername());
            userDetails.getUser().setToken(jwtUtil.generateToken(user.getUsername()));

            ;
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return userDetails.getUser();
    }



}
