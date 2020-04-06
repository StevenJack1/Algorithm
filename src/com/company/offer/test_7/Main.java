package com.company.offer.test_7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题7：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建出图2.6所示的二叉树并输出它的头结点。二叉树结点的定义如下：
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
    public static void preOrder(TreeNode treeNode){
        preOrderList.add(treeNode.value);
        if (treeNode.leftChild != null){
            preOrder(treeNode.leftChild);
        }
        if (treeNode.rightChild != null){
            preOrder(treeNode.rightChild);
        }
    }


    public static TreeNode reConstructBinaryTree(int[] prev,int[] in){
        if (prev.length != in.length || prev.length < 1){
            return null;
        }

        if (prev.length == 1){
            return new TreeNode(prev[0]);
        }

        int index = -1;
        for (int i = 0; i< in.length;i++){
            if (in[i] == prev[0]){
                index = i;
                break;
            }
        }

        if (index == -1){
            return null;
        }

        TreeNode root = new TreeNode(prev[0]);

        int[] leftChildPrev = new int[index];
        int[] leftChildIn = new int[index];
        System.arraycopy(prev,1,leftChildPrev,0,index);
        System.arraycopy(in,0,leftChildIn,0,index);
        root.leftChild = reConstructBinaryTree(leftChildPrev,leftChildIn);

        int[] rightChildPrev = new int[in.length-1-index];
        int[] rightChildIn = new int[in.length-1-index];
        System.arraycopy(prev,index+1,rightChildPrev,0,in.length-1-index);
        System.arraycopy(in,index+1,rightChildIn,0,in.length-1-index);
        root.rightChild = reConstructBinaryTree(rightChildPrev,rightChildIn);
        return root;

    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode root = reConstructBinaryTree(pre, in);

        preOrder(root);
        System.out.println(preOrderList);
    }
}
