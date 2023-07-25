package com.blog.blog.test.lombok;

import lombok.Value;

@Value
public class LombokUser2 {
  int id;
  String username;
  String password;
  int[] scores;
}
