package com.company;

import java.util.*;

public class Day0628 {

    /**
     * Divide Two Integers
     *
     * @param dividend
     * @param divisor
     * @return
     * @link https://leetcode.com/problems/divide-two-integers/
     * <p>
     * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * The integer division should truncate toward zero, which means losing its fractional part.
     * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
     * <p>
     * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
     * For this problem, assume that your function returns 231 − 1 when the division result overflows.
     * <p>
     * Example 1:
     * <p>
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Explanation: 10/3 = truncate(3.33333..) = 3.
     * Example 2:
     * <p>
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Explanation: 7/-3 = truncate(-2.33333..) = -2.
     * Example 3:
     * <p>
     * Input: dividend = 0, divisor = 1
     * Output: 0
     * Example 4:
     * <p>
     * Input: dividend = 1, divisor = 1
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * -231 <= dividend, divisor <= 231 - 1
     * divisor != 0
     */
    public int divide(int dividend, int divisor) {

        int flag =
                (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;

        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;

        // Recursion
        long ansLong = helper(Math.abs(dividend), Math.abs(divisor));

        return ansLong > Integer.MAX_VALUE ?
                ((flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE)
                :
                (int) (flag * ansLong);

    }

    private long helper(long dividend, long divisor) {

        if (dividend < divisor) return 0;

        long sum = divisor;
        long mutiple = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            mutiple += mutiple;
        }

        return mutiple + helper(dividend - sum, divisor);
    }

    /**
     * Minimum Deletions to Make Character Frequencies Unique
     *
     * @param s
     * @return
     * @link https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
     * <p>
     * A string s is called good if there are no two different characters in s that have the same frequency.
     * <p>
     * Given a string s, return the minimum number of characters you need to delete to make s good.
     * <p>
     * The frequency of a character in a string is the number of times it appears in the string.
     * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "aab"
     * Output: 0
     * Explanation: s is already good.
     * Example 2:
     * <p>
     * Input: s = "aaabbbcc"
     * Output: 2
     * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
     * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
     * Example 3:
     * <p>
     * Input: s = "ceabaacb"
     * Output: 2
     * Explanation: You can delete both 'c's resulting in the good string "eabaab".
     * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 105
     * s contains only lowercase English letters.
     */
    public static int minDeletions(String s) {

        int[] check = new int[26];
        int res = 0;

        for (char c : s.toCharArray()) {
            int idx =  c - 'a';
            check[idx]++;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < 26 ; i++) {
            while (check[i] > 0 && !used.add(check[i])) {
                check[i]--;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int min = minDeletions("aaaabbbcccciiiizzzzvvvv");
        System.out.println(min);
    }
}
