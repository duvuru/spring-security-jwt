package com.ragainfotech.service;

import com.ragainfotech.entity.User;
import com.ragainfotech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUsername = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(userByUsername.getUsername(),userByUsername.getPassword(), Collections.EMPTY_LIST);
    }
}
