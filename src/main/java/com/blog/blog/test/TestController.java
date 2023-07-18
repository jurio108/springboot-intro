package com.blog.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  
  private static final String TAG = "TestController : ";

  @GetMapping("/test/hello")
  public String hello() {
    return "<h1>hello</h1>";
  }

  @GetMapping("/http/lombok")
  public String lombokTest() {
    // Member member = new Member();
    Member member = Member.builder().username("aaa").password("ppp").email("aaa@ee.com").build();
    System.out.println(TAG + "getter : " + member.getId());
    member.setId(5000);
    System.out.println(TAG + "setter : " + member.getId());

    return "lombokTest : " + member.getId() + ", " + member.getUsername();
  }


  @GetMapping("/http/get")
  public String getTest(Member member) {
    return "get 요청 : " + member.getId() + ", " + member.getUsername();
  }

  @PostMapping("/http/post")
  public String postTest() {
    return "post 요청";
  }

  @PutMapping("/http/put")
  public String putTest() {
    return "put 요청";
  }

  @DeleteMapping("/http/delete")
  public String deleteTest() {
    return "delete 요청";
  }
}
