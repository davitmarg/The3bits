package com.example.the3bits.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService authentication;

    public SecurityConfiguration(MyUserDetailsService authentication) {
        this.authentication = authentication;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authentication);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/secure")
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(authentication);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
}
