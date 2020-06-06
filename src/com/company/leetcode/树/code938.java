package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 */
public class code938 {

    List<Integer> arr = new LinkedList<>();

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || L > R){
            return -1;
        }

        inOrder(root);
        int res = 0;
        for(int temp : arr){
            if (temp >= L && temp <= R){
                res += temp;
            }
        }

        return res;
    }

    public void inOrder(TreeNode root){
        if (root.left != null){
            inOrder(root.left);
        }
        arr.add(root.val);
        if (root.right != null){
            inOrder(root.right);
        }
    }



}
