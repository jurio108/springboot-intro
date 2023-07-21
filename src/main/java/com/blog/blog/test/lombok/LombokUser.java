package com.blog.blog.test.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "password")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class LombokUser {
  private int id;
  @NonNull private String username;
  @NonNull private String password;
  private int[] scores;
}
