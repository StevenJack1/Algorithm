package com.company.offer.test_28;

import com.company.offer.Tree.TreeNode;
import java.util.Stack;

/**
 * 面试题27：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 比如输入图4.12中左边的二叉搜索树，则输出转换之后的排序双向链表。
 */
public class Test28 {


    static TreeNode pre,head;

    // 中序遍历  左-根-右
    public static void inOrder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()){
                root = stack.pop();

                if (pre != null){
                    pre.rightChild = root;
                } else {
                    head = root;
                }
                root.leftChild = pre;
                pre = root;
                root = root.rightChild;
            }
        }

    }

    public static TreeNode test28(TreeNode root){

        if (root == null){
            return null;
        }
        inOrder(root);

        head.leftChild = pre;
        pre.rightChild = head;
        return head;

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

        test28(root);
        while (head != null){
            System.out.println(head.value);
            head = head.rightChild;
        }


    }

}
