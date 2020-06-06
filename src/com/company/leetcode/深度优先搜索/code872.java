package com.company.leetcode.深度优先搜索;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 872. 叶子相似的树
 *
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 提示：
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 *
 */
public class code872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }

        List<Integer> list1 = DFS(root1);
        List<Integer> list2 = DFS(root2);

        System.out.println(list1.toString());
        System.out.println(list2.toString());
        return list1.equals(list2);
    }

    public List<Integer> DFS(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left == null && cur.right == null){
                res.add(cur.val);
            }
        }

        return res;
    }



}
