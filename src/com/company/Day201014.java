package com.company;

public class Day201014 {
    /**
     * @author seongwou
     * @since 2020/10/14 1:53 오후
     * <p>
     * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
     * <p>
     * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
     * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
     **/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        int[] cnt = new int[1001], ans = new int[arr1.length];
        for (int i : arr1)                      // Count each number in arr1.
            ++cnt[i];
        for (int i : arr2)                      // Sort the common numbers in both arrays by the order of arr2.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        for (int i = 0; i < 1001; ++i)          // Sort the numbers only in arr1.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        return ans;
    }

    public static void main(String[] args) {

    }
}
