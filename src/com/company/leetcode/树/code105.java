package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class code105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length,inorder,0,inorder.length,map);
    }

    public TreeNode helper(int[] preorder,int p_start,int p_end,int[] inorder,int i_start,int i_end,Map<Integer,Integer> map){
        if (p_start == p_end){
            return null;
        }
        int temp = preorder[p_start];
        TreeNode root = new TreeNode(temp);
        int index = map.get(temp);

        int num = index - i_start;
        root.left = helper(preorder,p_start + 1,p_start+num+1,inorder,i_start,index,map);
        root.right = helper(preorder,p_start+num+1,p_end,inorder,index+1,i_end,map);
        return root;
    }
}
