package com.company;

public class Day210513 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] opt = new int[n + 1];
        opt[0] = 0; // init
        opt[1] = 0;
        for (int i = 2; i <= n; ++i) {
            opt[i] = Math.min(opt[i - 1] + cost[i - 1], opt[i - 2] + cost[i - 2]);
        }
        return opt[n];
    }

}
