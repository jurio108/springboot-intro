package com.blog.blog.test.lombok;

import com.blog.blog.test.Member;

import lombok.NonNull;

public class LombokNonNull {
  private String username;

  public LombokNonNull(@NonNull Member member) {
    this.username = member.getUsername();
  }

}
