package com.blog.blog.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class TestJpqlDto {
  private int cntAdmin;
  private int cntManager;
  private int cntUser;
}
