package com.duck.go2ductor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/30/2023
 */
@RestController
@RequestMapping("/api/file")
public class APIController {
    @Autowired
    private Environment env;

    @GetMapping("/images/{imageName}")
    public void getImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        String uploadDir = env.getProperty("spring.servlet.multipart.location");
        File file = new File(uploadDir  + "/" +  imageName);
        byte[] imageBytes = Files.readAllBytes(file.toPath());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageBytes);
        outputStream.close();
    }
}
