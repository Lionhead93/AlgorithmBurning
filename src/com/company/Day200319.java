package com.company;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day200319 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * * <p>
     * * Given linked list -- head = [4,5,1,9], which looks like following:
     **/
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(nums[i])) {
                result[0] = indices.get(nums[i]);
                result[1] = i;
                break;
            }
            indices.put(target - nums[i], i);

        }

        return result;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int cycle = 1;
        int[] first = new int[8];

        for (int i = 1; i < 7; i++) {
            first[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
        }
        N -= 1;

        for (int i = 0; i < 8; i++)
            cells[i] = first[i];


        while (N-- > 0) {

            int temp[] = new int[8];

            for (int i = 1; i < 7; i++) {
                temp[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
            }

            if (Arrays.equals(temp, first)) N %= cycle;

            System.arraycopy(temp, 0, cells, 0, 8);

            cycle++;
        }

        return cells;
    }

    public static void main(String[] args) {


    }
}
