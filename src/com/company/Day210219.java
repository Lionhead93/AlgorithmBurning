package com.company;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class Day210219 {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return diameter;
    }
    private int postOrder(TreeNode root){
        if(root == null) return 0;
        int leftSize = postOrder(root.left);
        int rightSize = postOrder(root.right);
        diameter = Math.max(diameter, leftSize + rightSize);
        return Math.max(leftSize, rightSize) + 1;
    }

}
