package com.duck.go2ductor.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */

@EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    @Qualifier("physicianDetailsService")
    private UserDetailsService physicianDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    @Qualifier("patientDetailsService")
    private UserDetailsService patientDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(physicianDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(patientDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-ui/**",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //the below three lines will add the relevant CORS response headers
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource()).and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/images/**").permitAll()
                .antMatchers("/api/review/**").permitAll()
                .antMatchers("/api/physician/get-profile/**").permitAll()
                .antMatchers("/api/physician/update/**").access("hasRole('ROLE_PHYSICIAN')")
                .antMatchers("/api/medical/**").permitAll()
                .antMatchers("/api/prescription/**").access("hasRole('ROLE_PHYSICIAN')")
                .antMatchers("/api/medicine/**").access("hasRole('ROLE_PHYSICIAN')")
                .antMatchers("/api/room/**").access("hasRole('ROLE_PHYSICIAN')")
                .antMatchers("/api/patient/**").access("hasAnyRole('ROLE_PHYSICIAN', 'ROLE_PATIENT')")
                .antMatchers("/api/appointment/**").permitAll()
                .antMatchers("/swagger-ui.html", "/configuration/**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().and()
                .logout().permitAll()
        ;
        http.cors();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


    }

}
