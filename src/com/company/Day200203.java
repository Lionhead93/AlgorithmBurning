package com.company;

import java.util.HashMap;
import java.util.Map;

public class Day200203 {

  // Given a string, find the length of the longest substring without repeating characters.
  public int lengthOfLongestSubstring(String s) {

    int answer = 0;
    int index = 0;
    while (index < s.length()) {
      String tmp = "";
      for (int i = index; i < s.length(); i++) {
        if (tmp.contains(String.valueOf(s.charAt(i)))) {
          break;
        } else {
          tmp += String.valueOf(s.charAt(i));
        }
      }
      if (tmp.length() > answer) {
        answer = tmp.length();
      }
      index++;
    }

    return answer;
  }

  public int lengthOfLongestSubstring2(String s) {
    int answer = 0;
    Map<Character, Integer> charToIndexMap = new HashMap<>();
    for (int i = 0, j = 0; i < s.length(); i++) {
      if (charToIndexMap.containsKey(s.charAt(i))) {
        int index = charToIndexMap.get(s.charAt(i));
        if (index >= j) {
          j = index + 1;
        } else {
          answer = Math.max(answer, i - j + 1);
        }
      } else {
        answer = Math.max(answer, i - j + 1);
      }
      charToIndexMap.put(s.charAt(i), i);
    }
    return answer;
  }
}
