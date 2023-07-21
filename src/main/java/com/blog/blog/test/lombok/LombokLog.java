package com.blog.blog.test.lombok;

import lombok.extern.java.Log;

@Log
public class LombokLog {
  public static void main(String... args) {
    log.severe("Something's wrong here");
  }
}
