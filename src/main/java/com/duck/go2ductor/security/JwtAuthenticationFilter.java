package com.duck.go2ductor.security;

import com.duck.go2ductor.dao.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/7/2023
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final String HEADER_STRING = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer";
    @Value(value = "${app.jwtSecret}")
    private String SECRET;
    @Value(value = "${app.jwtExpirationInMs}")
    private int EXPIRATION_TIME;
    @Autowired
    @Qualifier("physicianDetailsService")
    private UserDetailsService physicianDetailsService;

    @Autowired
    @Qualifier("patientDetailsService")
    private UserDetailsService patientDetailsService;

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
            UserDetailsService userDetailsService;
            if (loginRequest.getUserType().equals("ROLE_PHYSICIAN")) {
                userDetailsService = physicianDetailsService;
            } else if (loginRequest.getUserType().equals("ROLE_PATIENT")) {
                userDetailsService = patientDetailsService;
            } else {
                throw new BadCredentialsException("Invalid user type");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword(),
                    new ArrayList<>()
            );
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            authenticationToken.setDetails(loginRequest);

            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        LoginRequest loginRequest = (LoginRequest) authResult.getDetails();
        String token = Jwts.builder()
                .setSubject(((User) authResult.getPrincipal()).getUsername())
                .claim("role",loginRequest.getUserType())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}