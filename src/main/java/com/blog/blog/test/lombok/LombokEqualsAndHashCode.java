package com.blog.blog.test.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class LombokEqualsAndHashCode {
  // private transient int transientVar = 10;
  private String name;
  private double score;
  // private String[] tags;

  // @EqualsAndHashCode.Exclude 
  // private LombokUser user = new LombokUser(1, "jurio108", "1234", new int[]{100, 90, 95});
  
  // @EqualsAndHashCode.Exclude 
  // private int id;
  
  // public String getName() {
  //   return this.name;
  // }
}
