package com.spring.recrutement.config;


import com.spring.recrutement.Service.AuthUserDetailsService;
import com.spring.recrutement.filter.JwtFilter;
import com.spring.recrutement.util.AuthEntryPointJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
       // http.cors().disable();
        /* http.csrf().disable().authorizeRequests()
              //  .antMatchers("/user/**" , "/candidat/**" , "/offre/**" , "/candidature/**").hasAuthority("RH")
              //  .antMatchers("/candidat/all", "/offre/all" , "/candidature/all" , "/candidature/update" ).hasAuthority("MANAGER")
               // .antMatchers("/candidat/all", "/offre/all" , "/candidature/all" ).hasAuthority("USER")
               .antMatchers("/app/login").permitAll()
                .antMatchers("/intervention/**" ).hasAuthority("INTERVENTION")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ; */
                http./*cors().and().*/csrf().disable().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()
				.antMatchers("/app/**").permitAll()
				.antMatchers("/intervention/**").hasAuthority("INTERVENTION")
				.anyRequest()
				.authenticated();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        ;
    }
}
