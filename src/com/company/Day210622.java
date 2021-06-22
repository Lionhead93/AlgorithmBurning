package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day210622 {

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
     * If there is no future day for which this is possible, keep answer[i] == 0 instead.
     *
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     *
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     *
     * Input: temperatures = [30,60,90]
     * Output: [1,1,0]
     *
     * 1 <= temperatures.length <= 105
     * 30 <= temperatures[i] <= 100
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for(int i=0; i<answer.length; i++) {
            int j = i+1;
            while (j < temperatures.length) {
               if(temperatures[i] < temperatures[j]) {
                   answer[i] = j-i;
                   break;
               }
               if(j++ == temperatures.length) {
                   answer[i] = 0;
               }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.pop());
    }
}
