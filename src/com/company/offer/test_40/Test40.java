package com.company.offer.test_40;

import com.company.offer.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题39：二叉树的深度
 * 题目一：输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Test40 {


    /**
     * 两种方法，第一种深度优先搜索，利用递归实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.leftChild);
        int right = maxDepth(root.rightChild);

        return (left>right) ? (left+1) : (right+1);
    }

    public int maxDepth_second(TreeNode root){
        if (root == null) return 0;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : queue){
                if (node.leftChild != null) temp.add(node.leftChild);
                if (node.rightChild != null) temp.add(node.rightChild);
            }
            queue = temp;
            res++;
        }
        return res;
    }

}
