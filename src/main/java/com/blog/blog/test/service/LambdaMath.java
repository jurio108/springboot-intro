package com.blog.blog.test.service;

/**
 * @FunctionalInterface 
 * 구현해야 할 추상 메소드가 하나만 정의된 인터페이스
 * 두 개 이상의 메소드가 선언되면 자바 컴파일러가 오류를 발생
 */
@FunctionalInterface  
public interface LambdaMath {
  public int Calc(int first, int second);
  // public int Calc2(int first, int second);
}
