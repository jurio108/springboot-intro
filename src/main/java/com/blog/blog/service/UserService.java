package com.blog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.blog.model.User;
import com.blog.blog.repository.UserRepository;



@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Transactional
  public void join(User user) {    
    // user.updateUserRole(UserRole.USER);
    userRepository.save(user);
  }

  // readOnly = true : select할 때 트랜잭션 시작, 서비스 종료시 트랜잭션 종요
  @Transactional(readOnly = true)
  public User login(User user) {    
    return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
  }
}
