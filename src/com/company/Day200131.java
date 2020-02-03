package com.company;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;
import java.util.stream.Collectors;

public class Day200131 {

  public static int solution(String[] A) {
    String str = "";

    List<String> list = Arrays.asList(A);

    list.stream().sorted(Comparator.comparing(s -> s.length())).collect(Collectors.toList());

    Iterator it = list.iterator();

    return 0;
  }

  public static String solution2(String S) {

    String answer = "NO";

    char[] arr = S.toCharArray();

    for (int i = 0; i < arr.length / 2; i++) {
      if (arr[i] == '?') {
        if (arr[arr.length - (i + 1)] == '?') {
          arr[i] = 'a';
          arr[arr.length - (i + 1)] = 'a';
        } else {
          arr[i] = arr[arr.length - (i + 1)];
        }
      } else {
        if (arr[arr.length - (i + 1)] == '?') {
          arr[arr.length - (i + 1)] = arr[i];
        } else {
          if (arr[i] != arr[arr.length - (i + 1)]) {
            return answer;
          }
        }
      }
    }

    answer = new String(arr);
    return answer;
  }

  public static int solution3(int[] A) {

    int answer = 0;

    int pre = A[0];
    int nxt = (A[0] == 0) ? 1 : 0;

    if (A[0] == A[1]) {
      int tmp;
      tmp = pre;
      pre = nxt;
      nxt = tmp;
      answer++;
    }

    for (int i = 1; i < A.length; i++) {
      if (A[i] == pre) {
        answer++;
      }
      int tmp;
      tmp = pre;
      pre = nxt;
      nxt = tmp;
    }
    return answer;
  }

  public int solution4(int A, int B) {

    int cnt = 0;

    int m = A * B;

    String str = Integer.toBinaryString(m);

    for (char c : str.toCharArray()) {
      if (c == '1') {
        cnt++;
      }
    }

    return cnt;
  }

  public static int binaryGap(int N) {

    String binaryStr = Integer.toBinaryString(N);

    int answer = 0;

    int cnt = 0;

    for (int i = 0; i < binaryStr.length(); i++) {
      if (binaryStr.charAt(i) == '1') {
        if (cnt > answer) {
          answer = cnt;
        }
        cnt = 0;
      } else {
        cnt++;
      }
    }

    return answer;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNum(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }

  public void main(String[] args) {

    int a = binaryGap(32);

    System.out.println(a);
  }
}
