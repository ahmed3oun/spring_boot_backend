package com.spring.recrutement.filter;

import com.spring.recrutement.Service.AuthUserDetailsService;
import com.spring.recrutement.config.MyUserDetails;
import com.spring.recrutement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil ;
    @Autowired
    private AuthUserDetailsService service ;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse , FilterChain filterChain) throws ServletException, IOException {

        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods",	"GET,HEAD,OPTIONS,POST,PUT,DELETE");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers,Origin,Accept, "
                + "X-Requested-With, Content-Type, Access-Control-Request-Method,	"
                + "Access-Control-Request-Headers, Authorization");
        httpServletResponse.addHeader("Access-Control-Expose-Headers","Authorization, Access-ControlAllow-Origin,Access-Control-Allow-Credentials ");

        if (httpServletRequest .getMethod().equals("OPTIONS"))
        {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }


        // EXTRACT TOKEN
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String token = null;
        String username = null;


        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = service.loadUserByUsername(username);

            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
