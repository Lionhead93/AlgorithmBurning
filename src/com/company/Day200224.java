package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day200224 {

  public static int reverse(int x) {

    List<Integer> digits = new ArrayList<>();
    long returnValue = 0;

    int index = 0;
    while (x != 0) {
      int result = x / 10;
      int left = x % 10;
      digits.add(left);
      x = result;
      index++;
    }

    long multiplier = 1;
    for (int i = (digits.size() - 1); i >= 0; i--) {
      long newAdd = digits.get(i) * multiplier;
      returnValue += newAdd;
      multiplier *= 10;

      if (Math.abs(returnValue) > Integer.MAX_VALUE) {
        return 0;
      }
    }
    return (int) returnValue;
  }

  public static void main(String[] args) {
    System.out.println(reverse(-2147483648));
  }
}
