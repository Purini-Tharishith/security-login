package com.example.login.services.impl;

import com.example.login.repository.UserRepository;
import com.example.login.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   @Autowired
   private final UserRepository userRepository;

   @Override
   public UserDetailsService userDetailsService() {
       return new UserDetailsService() {
           @Override
           public UserDetails loadUserByUsername(String username) {
               return userRepository.findByEmail(username)
                       .orElseThrow(() -> new UsernameNotFoundException("user not found "));
           }
       };
   }
}
