package com.blog.blog.test.lombok;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.With;

public class LombokWith {
  @With(AccessLevel.PROTECTED) 
  @NonNull 
  private final String name;
  
  @With 
  private final int age;
  
  public LombokWith(@NonNull String name, int age) {
    this.name = name;
    this.age = age;
  }
}
