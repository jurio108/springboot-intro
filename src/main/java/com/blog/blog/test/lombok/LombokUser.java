package com.blog.blog.test.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "password")
public class LombokUser {
  private int id;
  private String username;
  private String password;
  private int[] scores;
}
