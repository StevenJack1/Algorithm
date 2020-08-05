package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class code538 {

    private List<TreeNode> list = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }

        inOrder(root);
        for (int i = list.size()-2; i >= 0; i--) {
            list.get(i).val += list.get(i+1).val;
        }
        return root;
    }

    public void inOrder(TreeNode cur){
        if (cur.left != null){
            inOrder(cur.left);
        }
        list.add(cur);
        if (cur.right != null){
            inOrder(cur.right);
        }
    }
}
