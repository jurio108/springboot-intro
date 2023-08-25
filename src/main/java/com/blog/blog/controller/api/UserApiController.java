package com.blog.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.config.auth.PrincipalDetail;
import com.blog.blog.dto.ResponseDto;
import com.blog.blog.model.User;
import com.blog.blog.service.UserService;

// import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private AuthenticationManager authenticationManager;

  // @Autowired
  // private HttpSession session;
  
  @PostMapping("/auth/joinProc")
  public ResponseDto<Integer> join(@RequestBody User user) {
    userService.join(user);
    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  }

  // without spring security
  // @PostMapping("/api/user/login")
  // public ResponseDto<Integer> login(@RequestBody User user) {
  //   User userData = userService.login(user);

  //   if(userData != null) {
  //     session.setAttribute("principal", userData);
  //   }

  //   return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  // }

  @PutMapping("/user")
  public ResponseDto<Integer> update(
    @RequestBody User user,
    @AuthenticationPrincipal PrincipalDetail principal
    ) {
    userService.update(user);

    // session 변경 :: 변경한 정보로 다시 인증시킴
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    
    SecurityContextHolder.getContext().setAuthentication(authentication);

    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  }
}
