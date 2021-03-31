package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day210330 {

    /**
     * 문제 설명
     * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
     * <p>
     * 제한사항
     * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
     * prices의 길이는 2 이상 100,000 이하입니다.
     * 입출력 예
     * prices	return
     * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
     * 입출력 예 설명
     * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
     * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
     * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
     * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
     * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
     *
     * @param prices
     * @return
     */
    public int[] solution_1(int[] prices) {

        Stack<Integer> beginIdxs = new Stack<>();
        int i = 0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i = 1; i < prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;

    }

    /**
     * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible
     * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     * <p>
     * <p>
     * Note:
     * <p>
     * S will have length in range [1, 500].
     * S will consist of lowercase English letters ('a' to 'z') only.
     */
    public List<Integer> partitionLabels(String S) {

        if (S == null || S.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string

        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {

            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start - 1);
                start = last + 1;
            }

        }
        return list;
    }

    /**
     * Given an integer num,
     * return an array of the number of 1's in the binary representation of every number in the range [0, num].
     * <p>
     * Example 1:
     * Input: num = 2
     * Output: [0,1,1]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * <p>
     * Example 2:
     * Input: num = 5
     * Output: [0,1,1,2,1,2]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */
    public static int[] countBits(int num) {
        int[] answer = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            int n = 0;
            int j = i;
            while (j > 1) {
                if (j % 2 == 1) {
                    n++;
                }
                j = j / 2;
                System.out.println(j);
            }
            answer[i] = n + j % 2;
        }
        return answer;
    }

    public int[] countBits_2(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1)
                count[i] = 1 + count[i >> 1];
            else
                count[i] = count[i >> 1];
        }
        return count;
    }

    /**
     * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order).
     * Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
     * <p>
     * Reconstruct and return the queue that is represented by the input array people.
     * The returned queue should be formatted as an array queue,
     * where queue[j] = [hj, kj] is the attributes of the jth person in the queue
     * (queue[0] is the person at the front of the queue).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * Explanation:
     * Person 0 has height 5 with no other people taller or the same height in front.
     * Person 1 has height 7 with no other people taller or the same height in front.
     * Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
     * Person 3 has height 6 with one person taller or the same height in front, which is person 1.
     * Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
     * Person 5 has height 7 with one person taller or the same height in front, which is person 1.
     * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
     * Example 2:
     * <p>
     * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
     * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= people.length <= 2000
     * 0 <= hi <= 106
     * 0 <= ki < people.length
     * It is guaranteed that the queue can be reconstructed.
     */
    public int[][] reconstructQueue(int[][] people) {
        return null;
    }

    /**
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * <p>
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     * <p>
     * Input: nums = [0]
     * Output: [[],[0]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * All the numbers of nums are unique.
     */

    public static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i < nums.length + 1; i++) {
            int[] combArr = new int[nums.length];

            doCombination(combArr, nums.length, i, 0, 0, nums);
        }

        return list;
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
        if (r == 0) {
            List<Integer> comb = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                comb.add(arr[combArr[i]]);
            }
            list.add(comb);
        } else if (target == n) {
            return;
        } else {
            combArr[index] = target;
            doCombination(combArr, n, r - 1, index + 1, target + 1, arr); // (i)
            doCombination(combArr, n, r, index, target + 1, arr); //(ii)
        }
    }


    public static void main(String[] args) {
        subsets(new int[]{1,2,3,4,5,6,7});
    }

}
