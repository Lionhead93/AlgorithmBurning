package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day200506 {

    /**
     * @author seongwou
     * @since 2020/05/06 1:00 오후
     * <p>
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * <p>
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     * <p>
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [5,6]
     **/
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[nums.length+1];
        for (int num : nums) {
            if (num != 0) {
                arr[num] = 1;
            }
        }
        for (int i=1; i<nums.length+1; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

}
