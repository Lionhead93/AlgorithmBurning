package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day200421 {

    /**
     * @author seongwou
     * @since 2020/04/21 1:19 오후
     * <p>
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     **/
    public int romanToInt(String s) {
        int answer = 0;
        char pre = '.';

        for (char c : s.toCharArray()) {
            int tmp = 0;
            switch (c) {
                case 'I':
                    tmp = 1;
                    break;
                case 'V':
                    tmp = pre == 'I' ? 3 : 5;
                    break;
                case 'X':
                    tmp = pre == 'I' ? 8 : 10;
                    break;
                case 'L':
                    tmp = pre == 'X' ? 30 : 50;
                    break;
                case 'C':
                    tmp = pre == 'X' ? 80 : 100;
                    break;
                case 'D':
                    tmp = pre == 'C' ? 300 : 500;
                    break;
                case 'M':
                    tmp = pre == 'C' ? 800 : 1000;
                    break;
            }
            answer += tmp;
            pre = c;
        }
        return answer;
    }

    /**
     * @author seongwou
     * @since 2020/04/21 1:21 오후
     * <p>
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     **/
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null)
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        else
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }


    public int cain(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            int depth = board[i-1].length - 1;
            int get = 0;
            while (depth > -1) {
                if (board[i-1][depth] == 0) {
                    depth--;
                } else {
                    get = board[i-1][depth];
                    break;
                }
            }
            if (get == 0) continue;

            if (!stack.isEmpty() && stack.peek() == get) {
                stack.pop();
            } else {
                stack.push(get);
            }
        }

        return stack.size();

    }

}
