package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Day200422 {

    /**
     * @author seongwou
     * @since 2020/04/22 3:29 오후
     * <p>
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     **/
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;
        while (i < j) {
            if (area < Math.min(height[i], height[j]) * (j - i)) {
                area = Math.min(height[i], height[j]) * (j - i);
            }
            if (height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return area;
    }

    /**
     * @author seongwou
     * @since 2020/04/22 4:47 오후
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate triplets.
     **/
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
