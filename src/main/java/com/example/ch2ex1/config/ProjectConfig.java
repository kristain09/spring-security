package com.example.ch2ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



// start after default, makes no auto generated password anymore.
@Configuration // marks the class as a configuration class
public class ProjectConfig {

    @Bean // instructs Spring to add the returned value as a bean in the Spring context
    // but, it is still no override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        //build a user with given username, password and authorities list
        UserDetails user = User
                .withUsername("kris")
                .password("12345")
                .authorities("read")
                .build();

        //Adds the user to be managed by UserDetailsService
        userDetailsService.createUser(user);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // good focus when it is just for example. it is not hashed anything at all.
        return NoOpPasswordEncoder.getInstance();// depcrecated
    }
}