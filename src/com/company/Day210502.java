package com.company;

public class Day210502 {

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

}
