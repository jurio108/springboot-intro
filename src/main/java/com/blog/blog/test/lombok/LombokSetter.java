package com.blog.blog.test.lombok;

import lombok.AccessLevel;
import lombok.Setter;

@Setter(AccessLevel.PROTECTED)
public class LombokSetter {
  
  private int id;
  private String username;
  private String password;
}
