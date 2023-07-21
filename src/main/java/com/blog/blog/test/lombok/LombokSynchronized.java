package com.blog.blog.test.lombok;

import lombok.Synchronized;

public class LombokSynchronized {
  private final Object object = new Object();

  @Synchronized
  public static void testSynchronized() {
    System.out.println("world");
  }

  @Synchronized
  public int testSynchronized2() {
    return 1;
  }

  @Synchronized("object")
  public void testSynchronized3() {
    System.out.println("hello");
  }
}
