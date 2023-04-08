package com.duck.go2ductor.dao;

import java.io.Serializable;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/7/2023
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}