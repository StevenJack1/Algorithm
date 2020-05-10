package com.company.offer.test_26;

import com.company.offer.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题25：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。二叉树结点的定义如下：
 */
public class Test26 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();





    public static void test26(TreeNode root){

        Stack<Integer> stack = new Stack<>();




    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(12);
        node5.leftChild = node1;
        node5.rightChild = node2;
        TreeNode root = new TreeNode(10);
        root.leftChild = node5;
        root.rightChild = node6;

        test26(root);
    }

}
