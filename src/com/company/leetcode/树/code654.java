package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class code654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return construct(nums,0,nums.length-1);
    }

    public TreeNode construct(int[] nums,int left,int right){
        if (left > right){
            return null;
        }
        int index = maxIndex(nums,left,right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums,left,index-1);
        root.right = construct(nums,index+1,right);
        return root;

    }

    public int maxIndex(int[] nums,int left,int right){
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[index] < nums[i]){
                index = i;
            }
        }
        return index;
    }

}
