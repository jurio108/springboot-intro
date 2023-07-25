package com.blog.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.model.User;
import com.blog.blog.model.UserRole;
import com.blog.blog.repository.UserRepository;

@RestController
public class DummyController {
  
  @Autowired
  private UserRepository userRepository;

  @PostMapping("dummy/join")
  public String join(User user) {
    user.setRole(UserRole.USER);
    userRepository.save(user);

    return "join complete";
  }
}
