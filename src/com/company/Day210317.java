package com.company;

public class Day210317 {

    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     * Example 1:
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     *
     * Example 2:
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     *
     * Example 3:
     * Input: root = []
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is i
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * Given the root of a binary tree, return the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     * The length of a path between two nodes is represented by the number of edges between them.
     *
     * Example 1:
     * Input: root = [1,2,3,4,5]
     * Output: 3
     * Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Example 2:
     * Input: root = [1,2]
     * Output: 1
     *
     * Constraints:
     * The number of nodes in the tree is in the range [1, 104].
     * -100 <= Node.val <= 100
     *
     * TODO :: diameterOfBinaryTree
     * @param root
     * @return
     */
    int ans=0;
    public int height(TreeNode root)
    {
        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        ans = Math.max(ans, lh+rh);

        int hmax = Math.max(lh, rh);

        return 1 + hmax;
    }

    public int diameterOfBinaryTree(TreeNode root)
    {
        height(root);
        return ans;
    }

}
