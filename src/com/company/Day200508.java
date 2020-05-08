package com.company;

import java.util.Arrays;

public class Day200508 {

    /**
     * @author seongwou
     * @since 2020/05/08 2:18 오후
     * <p>
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     * <p>
     * <p>
     * Above is a 7 x 3 grid. How many possible unique paths are there?
     **/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }

        Arrays.fill(dp[0], 1);

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
