package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.SimpleGrantedAuthority;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/7/2023
 */
@Service("physicianDetailsService")
public class PhysicianDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PhysicianRepository physicianRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Physician physician = physicianRepository.findByUsername(username);
        if (physician == null) {
            throw new UsernameNotFoundException("Physician not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_PHYSICIAN"));
        return new org.springframework.security.core.userdetails.User(
                physician.getUsername(),
                physician.getPassword(),
                authorities
        );
    }
}
