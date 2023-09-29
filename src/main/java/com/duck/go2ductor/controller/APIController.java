package com.duck.go2ductor.controller;

import com.duck.go2ductor.dao.SimpleGrantedAuthority;
import com.duck.go2ductor.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/30/2023
 */
@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("physicianDetailsService")
    private UserDetailsService physicianDetailsService;

    @Autowired
    @Qualifier("patientDetailsService")
    private UserDetailsService patientDetailsService;

    @Autowired
    private Environment env;

    @GetMapping("/images/{imageName}")
    public void getImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        String uploadDir = env.getProperty("spring.servlet.multipart.location");
        File file = new File(uploadDir + "/" + imageName);
        byte[] imageBytes = Files.readAllBytes(file.toPath());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageBytes);
        outputStream.close();
    }

    @GetMapping("/user")
    public String getUser(HttpServletRequest request) {
        String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = requestTokenHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        return username;
    }
}
