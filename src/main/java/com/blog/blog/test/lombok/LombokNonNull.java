package com.blog.blog.test.lombok;

import com.blog.blog.test.Member;

import lombok.NonNull;

public class LombokNonNull {
  public LombokNonNull(@NonNull Member member) {
    member.getUsername();
  }

}
