package com.company;

public class Day200626 {

    /**
     * @author seongwou
     * @since 2020/06/26 10:15 오전
     * <p>
     * Find the sum of all left leaves in a given binary tree.
     * <p>
     * Example:
     * <p>
     * 3
     * / \
     * 9  20
     * / \
     * 15  7
     * <p>
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     **/
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;

        return sum + helper(root.right) + helper(root.left);
    }

    /**
     * @author seongwou
     * <p>
     *     On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     * <p>
     *     Once you pay the cost, you can either climb one or two steps.
     *     You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
     * <p>
     *      Example 1:
     *      Input: cost = [10, 15, 20]
     *      Output: 15
     *      Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     *      Example 2:
     *      Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     *      Output: 6
     *      Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     *      Note:
     *      cost will have a length in the range [2, 1000].
     *      Every cost[i] will be an integer in the range [0, 999].
     **/
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] opt = new int[n + 1];
        opt[0] = 0; // init
        opt[1] = 0;
        for (int i = 2; i <= n; ++i) {
            opt[i] = Math.min(opt[i - 1] + cost[i - 1], opt[i - 2] + cost[i - 2]);
        }
        return opt[n];
    }


}
