package com.blog.blog.test.lombok;

public class LombokArgsConstructor {
  static void testArgsConstructor() {
    LombokUser user = LombokUser
    .builder()
    .scores(new int[]{100, 90})
    .password("1234")
    .username("jurio108")
    .id(1)
    .build();
  }
}
