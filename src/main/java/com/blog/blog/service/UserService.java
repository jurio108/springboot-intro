package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.model.User;
import com.blog.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Transactional
  public int join(User user) {
    try {
      userRepository.save(user);
      return 1;
    } catch (Exception e) {
       e.printStackTrace();
       System.out.println("UserService join() : " + e.getMessage());
    }
    
    return -1;
  }
}
