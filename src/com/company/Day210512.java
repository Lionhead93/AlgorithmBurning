package com.company;

public class Day210512 {

    public int superpalindromesInRange(String left, String right) {
        int from = (int) Math.ceil(Math.sqrt(Long.parseLong(left))), to = (int) Math.sqrt(Long.parseLong(right)), count = 0;
        for(int p = next(from - 1); p <= to; p = next(p)) {
            if(isPalindrome((long) p * p)) {
                count++;
            }
        }
        return count;
    }
    private int next(int num) {
        char[] s = String.valueOf(num + 1).toCharArray();
        for(int i = 0, n = s.length; i < (n >> 1); i++) {
            while(s[i] != s[n - 1 - i]) {
                increment(s, n - 1 - i);
            }
        }
        return Integer.parseInt(new String(s));
    }
    private void increment(char[] s, int i) {
        while(s[i] == '9') s[i--] = '0';
        s[i]++;
    }
    private boolean isPalindrome(long n) {
        long orig = n, rev = 0;
        while(n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return orig == rev;
    }

}
