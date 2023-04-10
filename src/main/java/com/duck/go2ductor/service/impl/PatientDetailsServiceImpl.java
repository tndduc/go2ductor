package com.duck.go2ductor.service.impl;

import com.duck.go2ductor.dao.SimpleGrantedAuthority;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/7/2023
 */
@Service("patientDetailsService")
public class PatientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByUsername(username);
        if (patient == null) {
            throw new UsernameNotFoundException("Patient not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_PHYSICIAN"));
        return new org.springframework.security.core.userdetails.User(
                patient.getUsername(),
                patient.getPassword(),
                authorities
        );
    }

}