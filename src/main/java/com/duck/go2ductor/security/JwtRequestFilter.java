package com.duck.go2ductor.security;

import com.duck.go2ductor.dao.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/8/2023
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("physicianDetailsService")
    private UserDetailsService physicianDetailsService;

    @Autowired
    @Qualifier("patientDetailsService")
    private UserDetailsService patientDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        // JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                logger.info(jwtToken);
                logger.info("JWT Token extracted successfully for user: " + username);
            } catch (IllegalArgumentException e) {
                logger.info(jwtToken);
                logger.error("Unable to get JWT Token");
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
            logger.info(jwtToken);
        }

        // Once we get the token validate it.
        if (username != null) {
            UserDetails userDetails = null;
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (physicianDetailsService.loadUserByUsername(username) != null) {
                userDetails = physicianDetailsService.loadUserByUsername(username);
                authorities.add(new SimpleGrantedAuthority("ROLE_PHYSICIAN"));
            } else if (patientDetailsService.loadUserByUsername(username) != null) {
                userDetails = patientDetailsService.loadUserByUsername(username);
                authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
            }
            // if token is valid configure Spring Security to manually set authentication
            if (jwtTokenUtil.validateToken(jwtToken)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities);
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                for (GrantedAuthority authority : authorities) {
                    logger.info("Authority: " + authority.getAuthority());
                }
            }
        }
        chain.doFilter(request, response);
    }
}