package com.blog.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.blog.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
  
  @GetMapping({"", "/"})
  public String index(
    @AuthenticationPrincipal PrincipalDetail principal
  ) {
    System.out.println("BoardController :: login");
    
    if(principal == null) {
      return "user/loginForm";
    } else {
      System.out.println("login success : " + principal.getUsername());
      return "index";
    }
  }
}
