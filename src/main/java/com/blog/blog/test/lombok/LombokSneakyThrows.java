package com.blog.blog.test.lombok;

import java.io.IOException;
// import java.io.UnsupportedEncodingException;

import lombok.SneakyThrows;

public class LombokSneakyThrows {
  
  // @SneakyThrows(UnsupportedEncodingException.class)
  // public static String testSneackThrows(byte[] bytes) {
  //   return new String(bytes, "UTF-8");
  // }

  @SneakyThrows(IOException.class)
  public void testSneackThrows2() {
    throw new IOException("IOException");
  }
}
