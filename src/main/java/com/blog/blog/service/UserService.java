package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.model.User;
// import com.blog.blog.model.UserRole;
import com.blog.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Transactional
  public void join(User user) {    
    // user.updateUserRole(UserRole.USER);
    userRepository.save(user);
  }
}
