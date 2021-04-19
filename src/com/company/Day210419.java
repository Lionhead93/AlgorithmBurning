package com.company;

public class Day210419 {

    /**
     * There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer, ,
     * find and print the number of letter a's in the first  letters of the infinite string.
     * @param s
     * @param n
     * @return
     */
    public long repeatedString(String s, long n) {

        if(!s.contains("a")) return 0;

        long rem = n%s.length();
        long c = 0;
        long remc = 0;

        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i)=='a') {
                c++;
                if(i < rem) {
                    remc++;
                }
            }
        }
        return c * (n/s.length()) + remc;
    }

    /**
     * Given a  6x6 2D Array, arr :
     *
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * An hourglass in A is a subset of values with indices falling in this pattern in arr's graphical representation:
     *
     * a b c
     *   d
     * e f g
     * There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values.
     * Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
     * The array will always be 6x6.
     * @param arr
     * @return
     */
    static int hourglassSum(int[][] arr) {

        int answer = Integer.MIN_VALUE;
        for(int i=1; i<5; i++) {
            for(int j=1; j<5; j++) {
                answer = Math.max(getHourglassSum(arr, i, j), answer);
            }
        }
        return answer;
    }

    static int getHourglassSum(int[][] arr, int x, int y) {
        return arr[x][y]
                + arr[x-1][y+1]
                + arr[x-1][y]
                + arr[x-1][y-1]
                + arr[x+1][y+1]
                + arr[x+1][y]
                + arr[x+1][y-1];
    }

}
