package com.example.p04_consumidor_control.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfSeg {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .authorizeHttpRequests(registry -> {
                //registry.requestMatchers("/").permitAll();
                registry.requestMatchers("/").hasRole("USER");
                registry.requestMatchers("/anexar").hasRole("ADMIN");
                registry.requestMatchers("/salvar").hasRole("ADMIN");
                registry.requestMatchers("/cambiar/**").hasRole("ADMIN");
                registry.requestMatchers("/borrar/**").hasRole("ADMIN");
                registry.anyRequest().authenticated();
            })
            //.formLogin(formLogin -> formLogin.permitAll())
            .formLogin(httpSecurityFormLoginConfigurer -> {
                httpSecurityFormLoginConfigurer.loginPage("/registro").permitAll();
            })
            .exceptionHandling(exceptionHandling -> {
                exceptionHandling.accessDeniedPage("/errores/403");
            })
            .build()
        ;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User.builder()
            .username("user")
            .password("$2a$12$mWVelnlhMrmT.3g1IRxX5OBcKssLWGIRJu8Buhfy8hVsiAohOVttO")   //user
            .roles("USER")
            .build()
        ;

        UserDetails adminUser = User.builder()
            .username("admin")
            .password("$2a$12$NSV42lAmHV.eI8QXX6zIu.P3XuBZG7iWjelO3bVzoIfaSPun3chgq")   //admin
            .roles("ADMIN", "USER")
            .build()
        ;

        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
