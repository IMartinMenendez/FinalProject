package com.ironhack.userservice.services;

import com.ironhack.userservice.model.User;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.security.CustomUserDetails;
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
    Optional<User> optionalUser = userRepository.getUserByName(username);
    if (optionalUser.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }

    return new CustomUserDetails(optionalUser.get());
  }
}
