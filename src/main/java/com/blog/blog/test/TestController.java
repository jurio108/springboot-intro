package com.blog.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.test.lombok.LombokEqualsAndHashCode;
import com.blog.blog.test.lombok.LombokSneakyThrows;
import com.blog.blog.test.lombok.LombokUser;

// import lombok.var;

@RestController
public class TestController {
  
  private static final String TAG = "TestController : ";

  @GetMapping("/test/hello")
  public String hello() {
    return "<h1>hello</h1>";
  }

  @GetMapping("/lombok")
  public String lombokTest() {
    // Member member = new Member();
    Member member = Member.builder().username("aaa").password("ppp").email("aaa@ee.com").build();
    System.out.println(TAG + "getter : " + member.getId());
    member.setId(5000);
    System.out.println(TAG + "setter : " + member.getId());

    return "lombokTest : " + member.getId() + ", " + member.getUsername();
  }

  @GetMapping("/lombok/tostring")
  public String lombokTostring() {
    LombokUser user = new LombokUser("jurio108", "1234");

    user.setId(1);
    user.setUsername("jurio108");
    user.setPassword("1234");
    user.setScores(new int[]{100, 90, 95});

    // User(id=1, username=jurio108, password=1234, scores=[100, 90, 95])
    System.out.println(user);

    return "ok";
  }

  @GetMapping("/lombok/hash")
  public String lombokEqualsAndHashCode() {
    LombokEqualsAndHashCode hash = new LombokEqualsAndHashCode("jurio108", 100);
    LombokEqualsAndHashCode hash2 = new LombokEqualsAndHashCode("jurio108", 100);
    
    System.out.println(hash.equals(hash2));
    System.out.println(hash.hashCode());
    System.out.println(hash2.hashCode());

    return "ok";
  }

  @GetMapping("/lombok/args")
  public String lombokArgs() {
    LombokUser user = new LombokUser("jurio108", "1234");
    LombokUser user2 = new LombokUser();

    user.setId(1);
    user.setUsername("jurio108");
    user.setPassword("1234");
    user.setScores(new int[]{100, 90, 95});

    // LombokUser(id=1, username=jurio108, password=1234, scores=[100, 90, 95])
    System.out.println(user);
    // LombokUser(id=0, username=null, scores=null)
    System.out.println(user2);

    return "ok";
  }

  @GetMapping("/lombok/sneacky")
  public String lombokSneacky() {
    LombokSneakyThrows sneaky = new LombokSneakyThrows();

    try {
      sneaky.testSneackThrows2();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    return "ok";
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
