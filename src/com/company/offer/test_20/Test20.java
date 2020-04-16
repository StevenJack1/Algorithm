package com.company.offer.test_20;

import com.company.offer.Tree.TreeNode;

import java.util.Stack;

/**
 * 面试题19：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。二叉树结点的定义如下：
 */
public class Test20 {

    public static void test20(TreeNode root){

        if (root == null || (root.leftChild == null && root.rightChild == null)){
            return;
        }

        TreeNode temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;

        if (root.leftChild != null){
            test20(root.leftChild);
        }

        if (root.rightChild != null){
            test20(root.rightChild);
        }

    }


    public static void test20No(TreeNode root){

        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.leftChild != null){
                stack.push(node.leftChild);
            }
            if (node.rightChild != null){
                stack.push(node.rightChild);
            }
            TreeNode temp = node.leftChild;
            node.leftChild = node.rightChild;
            node.rightChild = temp;
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(10);
        node5.leftChild = node1;
        node5.rightChild = node2;
        node6.leftChild = node3;
        node6.rightChild = node4;
        TreeNode root = new TreeNode(8);
        root.leftChild = node5;
        root.rightChild = node6;

        test20(root);


    }


}
