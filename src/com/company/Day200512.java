package com.company;

public class Day200512 {

    /**
     * @author seongwou
     * @since 2020/05/12 11:14 오전
     * <p>
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * Note: Given n will be a positive integer.
     **/
    public int climbStairs(int n) {

        int[] move = new int[n];
        return climb(0, n, move);


    }

    private int climb(int curr, int n, int[] move,) {

        if(curr == n) return 1;
        if(curr > n) return 0;
        if(move[curr] != 0) {
            return move[curr];
        }
        move[curr] = climb(curr+1, n, move) + climb(curr+2, n, move);
        return move[curr];
    }

}
