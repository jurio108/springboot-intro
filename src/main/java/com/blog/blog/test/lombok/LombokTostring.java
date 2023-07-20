package com.blog.blog.test.lombok;

public class LombokTostring {
  
  public void toStringTest() {
    LombokUser user = new LombokUser();

    user.setId(1);
    user.setUsername("jurio108");
    user.setPassword("1234");
    user.setScores(new int[]{100, 90, 95});

    // User(id=1, username=jurio108, password=1234, scores=[100, 90, 95])
    System.out.println(user);
  }
}
