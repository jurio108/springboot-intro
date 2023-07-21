package com.blog.blog.test.lombok;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.val;
// import lombok.var;

public class LombokVal {

  public String varTest1() {
    
    val example1 = new ArrayList<String>();
    example1.add("Hello, World!");
    val foo1 = example1.get(0);

    final ArrayList<String> example2 = new ArrayList<String>();
    example2.add("Hello, World!");
    final String foo2 = example2.get(0);

    val map1 = new HashMap<Integer, String>();
    map1.put(0, "zero");
    map1.put(5, "five");
    for (val entry : map1.entrySet()) {
      System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
    }

    System.out.printf("foo1 : ", foo1.length(), "foo2 : ", foo2.length());

    return null;
  }
}
