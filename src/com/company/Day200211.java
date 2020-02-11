package com.company;

public class Day200211 {

  public static String convert(String s, int r) {
      if(r>=s.length() || r==1)
          return s;
      int n = 2*r-2;
      int next[] = new int[r];
      for(int i=0; i<r; i++){
          next[i] = i<r-1? n-2*i: n;
      }
      StringBuilder ans = new StringBuilder("");
      for(int i=0; i<r; i++){
          int k = i;
          boolean odd = true;
          while(k<s.length()){
              ans.append(s.charAt(k));
              if(odd)
                  k += next[i];
              else
                  k += next[r-i-1];
              odd = !odd;
          }
      }
      return ans.toString();
  }

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 3));
    System.out.println(convert("PAYPALISHIRING", 4));
  }
}
