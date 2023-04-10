package com.duck.go2ductor.dao;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/8/2023
 */
public class SimpleGrantedAuthority implements GrantedAuthority {

    private final String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
