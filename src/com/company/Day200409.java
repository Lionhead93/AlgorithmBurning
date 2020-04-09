package com.company;

public class Day200409 {

    /**
     * @author seongwou
     * @since 2020/04/09 2:33 오후
     * <p>
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     **/
    public static String reverseWords(String s) {
      char[] ch = s.toCharArray();

      int i=0, j=0;

      while(i < ch.length) {
          while(i<ch.length && ch[i] == ' ') i++;
          j = i;
          while(j< ch.length && ch[j] != ' ') j++;
          reverseWord(ch, i, j);
          i = j;
      }


      return new String(ch);
    }

    public static void reverseWord(char[] c, int st, int end) {
        while(st < end) {
            char tmp = c[st];
            c[st++] = c[end];
            c[end--] = tmp;
        }
    }

    public static void main(String[] args) {

    }

}
