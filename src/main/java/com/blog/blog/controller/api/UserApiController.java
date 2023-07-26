package com.blog.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dto.ResponseDto;
import com.blog.blog.model.User;
import com.blog.blog.model.UserRole;
import com.blog.blog.service.UserService;

@RestController
public class UserApiController {
  
  @Autowired
  private UserService userService;
  
  @PostMapping("/api/user")
  public ResponseDto<Integer> join(@RequestBody User user) {
    user.setRole(UserRole.USER);
    userService.join(user);
    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  }
}
