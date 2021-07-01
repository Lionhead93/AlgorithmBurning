package com.company;

public class Day210701 {

    public static String longestPalindrome(String s) {

        int n = s.length();
        String res = "";
        int maxLen = 0;
        boolean[][] table = new boolean[n][n];

        // i == j -> true
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (i == j) table[i][j] = true;

        // s.charAt(i) == s.charAt(j) && len == 2 -> true
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (s.charAt(i) == s.charAt(j) && j - i + 1 == 2) table[i][j] = true;

        // s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == true
        for (int j = 0; j < n; j++)
            for (int i = 0; i < n; i++)
                if (s.charAt(i) == s.charAt(j) && i + 1 < n && (j - 1 > -1) && table[i + 1][j - 1])
                    table[i][j] = true;

        // find longest res
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (table[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }

        return res;
    }

}
