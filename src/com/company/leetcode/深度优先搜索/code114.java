package com.company.leetcode.深度优先搜索;

import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class code114 {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        List<TreeNode> list = new LinkedList<>();
        dfs(root,list);
        int size = list.size();

        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i-1);
            prev.left = null;
            prev.right = list.get(i);
        }
    }

    public void dfs(TreeNode root,List<TreeNode> list){
        list.add(root);
        if (root.left != null) dfs(root.left,list);
        if (root.right != null) dfs(root.right,list);
    }
}
