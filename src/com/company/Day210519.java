package com.company;

public class Day210519 {

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

}
