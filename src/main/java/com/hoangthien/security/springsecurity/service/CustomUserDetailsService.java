package com.hoangthien.security.springsecurity.service;

import com.hoangthien.security.springsecurity.model.CustomUserDetails;
import com.hoangthien.security.springsecurity.model.Users;
import com.hoangthien.security.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepository.findByFirstName(username);
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
}
