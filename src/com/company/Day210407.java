package com.company;

import java.util.Arrays;

public class Day210407 {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
     *
     * Example 1:
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     *
     * Example 2:
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, here = m + n - 1;
        while(i1 >= 0 && i2 >= 0) {
            if(nums1[i1] >= nums2[i2]) {
                nums1[here--] = nums1[i1--];
            } else {
                nums1[here--] = nums2[i2--];
            }
        }
        while(i2 >= 0) {
            nums1[here--] = nums2[i2--];
        }
    }
}
