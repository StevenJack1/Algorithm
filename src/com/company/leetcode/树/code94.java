package com.company.leetcode.树;

import com.company.leetcode.TreeNode;
import com.sun.deploy.panel.ITreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class code94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode temp, List<Integer> res) {
        if (temp.left != null) {
            traversal(temp.left, res);
        }
        res.add(temp.val);
        if (temp.right != null) {
            traversal(temp.right, res);
        }
    }

    public List<Integer> inorderTraversal_second(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
