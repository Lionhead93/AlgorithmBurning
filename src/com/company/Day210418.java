package com.company;

import java.util.Arrays;
import java.util.List;

public class Day210418 {

    /**
     * Given an array of integers, what is the length of the longest subarray containing no more than two distinct values
     * such that the distinct values differ by no more than 1?
     * 연속된 2개의 숫자로 이루어진 가장 큰 배열
     * @param arr
     * @return
     */
    public static int longestSubarray(List<Integer> arr) {

        int answer = 0;
        int curr = 1;
        for (int i = 1; i < arr.size(); i++) {

            if (Math.abs(arr.get(i) - arr.get(i - 1)) == 1) {
                curr++;
            } else {
                if (curr != 1 && curr > answer) {
                    answer = curr;
                    curr = 1;
                }
            }

        }
        if (curr != 1 && curr > answer) {
            answer = curr;
        }
        return answer;
    }

    static int jumpingOnClouds(int[] c) {
        int answer = 0;
        int curr = 0;
        while(curr < c.length-1) {
            if(curr == c.length-2) {
                answer++;
                break;
            }

            if(c[curr+2] == 0) {
                curr += 2;
            } else {
                curr++;
            }
            answer++;
        }
        return answer;
    }

}
