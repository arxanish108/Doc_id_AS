package com.generateToken.generateToken.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {
    // ,"/clinic/amount"
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests
                    .requestMatchers("/authenticate/**", "/sign-up", "/register", "/clinic/betweenDate",
                            "/appointment/book1", "/clinic/getApt", "/image/**", "/clinic/add", "/clinic/amount",
                            "/medicine-prescriptions/**", "/prescriptions/**", "/home/amount", "/home/**",
                            "/http://localhost:9090/**", "/http://localhost:3000/**", "/payment/**", "/clinic/**",
                            "/inter/add")
                    .permitAll()
                    .requestMatchers("/api/**").authenticated();
        }).sessionManagement(
                sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
