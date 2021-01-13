package com.company;

/**
 * @author seongwou
 * @since 21. 1. 13. 오전 11:23
 * You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
 * <p>
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * If target is found in the array return its index, otherwise, return -1.
 **/
public class Day210113 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int idx = findPivotIdx(nums);

        int first = binSearch(nums, 0, idx - 1, target);
        int sec = binSearch(nums, idx, nums.length - 1, target);

        if (first == sec) {
            return -1;
        }
        return first > sec ? first : sec;
    }

    private int findPivotIdx(int[] nums) {
        int l = -1;
        int r = nums.length - 1;

        while (r - l > 1) {
            int m = (r + l) / 2;
            if (nums[m] > nums[r]) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    private int binSearch(int[] nums, int start, int end, int target) {
        int l = start - 1;
        int r = end + 1;
        while (r - l > 1) {
            int m = (r + l) / 2;
            if (nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        if (l != -1 && nums[l] == target) {
            return l;
        }
        return -1;
    }
}
