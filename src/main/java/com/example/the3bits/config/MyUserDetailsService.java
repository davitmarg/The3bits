package com.example.the3bits.config;

import com.example.the3bits.rest.persistence.user.User;
import com.example.the3bits.rest.service.user.UserServiceInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserServiceInterface userService;

    public MyUserDetailsService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String term) throws UsernameNotFoundException {
        User user = userService.findByEmailOrUsername(term);
        if (user == null) {

            throw new UsernameNotFoundException(term);
        }

        return new MyUserDetails(user.getUsername(),user.getPassword(), user.getRole().name());
    }
}
