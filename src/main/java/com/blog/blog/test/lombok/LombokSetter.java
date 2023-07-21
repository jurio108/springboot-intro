package com.blog.blog.test.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PROTECTED)
@Getter
public class LombokSetter {
  
  private int id;
  private String username;
  private String password;
}
