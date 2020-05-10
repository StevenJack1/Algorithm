package com.company.offer.test_24;

import com.company.offer.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题23：从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 * 例如输入图4.5中的二叉树，则依次打印出8、6、10、5、7、9、11。
 */
public class Test24 {

    public static void test24(TreeNode root){
        Queue<TreeNode> a = new LinkedList<>();

        if (root == null){
            return;
        }

        a.offer(root);

        while (!a.isEmpty()){

            TreeNode temp = a.poll();
            System.out.println(temp.value);
            if (temp.leftChild != null){
                a.offer(temp.leftChild);
            }
            if (temp.rightChild != null){
                a.offer(temp.rightChild);
            }

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

        test24(root);
    }


}
