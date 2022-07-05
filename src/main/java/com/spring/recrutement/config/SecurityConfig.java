package com.spring.recrutement.config;


import com.spring.recrutement.Service.AuthUserDetailsService;
import com.spring.recrutement.filter.JwtFilter;
import com.spring.recrutement.util.AuthEntryPointJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler ;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
                http./*cors().and().*/csrf().disable().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()
                /* Authorized APIs */
				.antMatchers("/app/**",
                "/gouvernement/all","/gouvernement/add","/gouvernement/find/**").permitAll()
                /* Intervention authorized APIs */
				.antMatchers("/intervention/**").hasAuthority("INTERVENTION")
                /* USER authorized APIs */
                .antMatchers(
                "/siteradio/all","/siteradio/update","/siteradio/delete","/siteradio/add","/siteradio/find/**"
                ,"/cellule/notUsed","/cellule/add","/cellule/all","/cellule/find/**","/cellule/update/**"
                ,"/document/all","/document/add","/document/updateDoc","/document/update/**","/document/find/**"
                ).hasAuthority("USER")
                /* MANAGER authorized APIs */
                .antMatchers(
                "/siteradio/all","/siteradio/update","/siteradio/delete","/siteradio/add","/siteradio/find/**"
                ,"/cellule/notUsed","/cellule/add","/cellule/all","/cellule/find/**","/cellule/update/**"
                ,"/document/all","/document/add","/document/updateDoc","/document/update/**","/document/find/**"
                ).hasAuthority("MANAGER")
                /* ENGINEER authorized APIs */
                .antMatchers("/user/all"
                ,"/siteradio/all","/siteradio/update","/siteradio/delete","/siteradio/add","/siteradio/find/**"
                ,"/cellule/add","/cellule/all","/cellule/find/**","/cellule/notUsed","/cellule/update/**"
                ,"/document/all","/document/add","/document/updateDoc","/document/update/**","/document/find/**"
                ).hasAuthority("ENGINEER")
                /* ADMIN authorized APIs */
                .antMatchers(
                "/user/all","/user/add","/user/find/**","/user/update","/user/updateimg","/user/delete/**"
                ,"/siteradio/all","/siteradio/update","/siteradio/delete","/siteradio/add","/siteradio/find/**"
                ,"/document/all","/document/add","/document/updateDoc","/document/update/**","/document/find/**"
                ,"/cellule/notUsed","/cellule/add","/cellule/all","/cellule/find/**","/cellule/update/**"
                ,"/role/add","/role/all"
                ).hasAuthority("ADMIN")

				.anyRequest()
				.authenticated();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        ;
    }
}
