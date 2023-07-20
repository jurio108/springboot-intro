package com.blog.blog.test.lombok;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import lombok.Cleanup;

public class LombokCleanup {
  public void TestCleanup(String[] arrString) {
    try {
      @Cleanup InputStream in = new FileInputStream(arrString[0]);
      @Cleanup OutputStream out = new FileOutputStream(arrString[1]);
      byte[] b = new byte[10000];
      while (true) {
        int r = in.read(b);
        if (r == -1) break;
        out.write(b, 0, r);
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }

}
