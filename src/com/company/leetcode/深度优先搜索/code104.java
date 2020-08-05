package com.company.leetcode.深度优先搜索;


import com.company.leetcode.TreeNode;


import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class code104 {

    public int maxDepth(TreeNode root) {
        Stack<Record> stack = new Stack<>();

        if (root == null){
            return 0;
        }
        stack.push(new Record(root,1));
        int depth = 0;

        while (!stack.isEmpty()){
            Record cur = stack.pop();
            depth = Math.max(depth,cur.depth);
            TreeNode temp = cur.root;

            if (temp.left != null){
                stack.push(new Record(temp.left,cur.depth+1));
            }
            if (temp.right != null){
                stack.push(new Record(temp.right,cur.depth+1));
            }
        }
        return depth;
    }

    public class Record {
        TreeNode root;
        int depth;
        Record(TreeNode root,int depth){
            this.root = root;
            this.depth = depth;
        }
    }
}
