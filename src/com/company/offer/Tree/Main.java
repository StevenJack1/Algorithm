package com.company.offer.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树节点的定义
 */
class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(int value) {
        this.value = value;
    }
}


public class Main {
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> inOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    /**
     * 前序遍历，递归方法，根-左-右
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode){
        preOrderList.add(treeNode.value);
        if (treeNode.leftChild != null){
            preOrder(treeNode.leftChild);
        }
        if (treeNode.rightChild != null){
            preOrder(treeNode.rightChild);
        }
    }

    /**
     * 前序遍历，非递归方法
     * @param treeNode
     */
    public static void preOrderNon(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                preOrderList.add(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 中序遍历，递归方法，左-根-右
     * @param treeNode
     */
    public static void inOrder(TreeNode treeNode){
        if (treeNode.leftChild != null){
            inOrder(treeNode.leftChild);
        }
        inOrderList.add(treeNode.value);
        if (treeNode.rightChild != null){
            inOrder(treeNode.rightChild);
        }
    }

    /**
     * 后序遍历，非递归
     * @param treeNode
     */
    public static void inOrderNon(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                inOrderList.add(treeNode.value);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 后序遍历，递归方法，左-右-根
     * @param treeNode
     */
    public static void postOrder(TreeNode treeNode){
        if (treeNode.leftChild != null){
            postOrder(treeNode.leftChild);
        }
        if (treeNode.rightChild != null){
            postOrder(treeNode.rightChild);
        }
        postOrderList.add(treeNode.value);
    }

    /**
     * 后序遍历，非递归
     * 一个思路，双栈，按照根-右-左的方法压入stack2中，在pop出来
     * @param treeNode
     */
    public static void postOrderNon(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                stack2.push(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.rightChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.leftChild;
            }
        }
        while (!stack2.isEmpty()){
            postOrderList.add(stack2.pop());
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(16);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        node5.leftChild = node1;
        node5.rightChild = node2;
        node6.leftChild = node3;
        node6.rightChild = node4;
        TreeNode root = new TreeNode(10);
        root.leftChild = node5;
        root.rightChild = node6;

//        preOrderNon(root);
//        inOrder(root);
        postOrderNon(root);
        System.out.println(preOrderList);
        System.out.println(inOrderList);
        System.out.println(postOrderList);
    }


}
