package com.blog.blog.test.service;

import java.util.function.IntFunction;

import org.springframework.stereotype.Service;

@Service
public class LambdaService {
  
  public int[] FunctionalImpl(int first, int second) {
    LambdaMath plus = (x, y) -> x + y;
    System.out.println("FunctionalInterface plus : " + plus.Calc(3, 4));

    LambdaMath minus = (x, y) -> x - y;
    System.out.println("FunctionalInterface minus : " + minus.Calc(4, 3));

    return new int[]{plus.Calc(3, 4), minus.Calc(4, 3)};
  }

  public int IntFunc(int first) {
    // IntFunction<T> int값의 인수를 쓰고 결과 생성하는 함수
    IntFunction<Integer> intSum = (x) -> x + 1;

    System.out.println("IntFunction : " + intSum.apply(first));

    return intSum.apply(first);
  }


}
