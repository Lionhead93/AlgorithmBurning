package com.company;

public class Day200417 {

    /**
     * @author seongwou
     * @since 2020/04/17 1:41 오후
     * <p>
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * <p>
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * <p>
     * Note:
     * <p>
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     **/
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i++)
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    if (j > 1) {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                        dp[i][j] = dp[i][j] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

}
