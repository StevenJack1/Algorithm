package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 */
public class code617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null){
            return t2;
        }
        if (t2==null){
            return t1;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(t1);
        queue2.add(t2);

        while (!queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            node1.val += node2.val;
            if (node2.left != null){
                if (node1.left == null){
                    node1.left = new TreeNode(0);
                }
                queue1.add(node1.left);
                queue2.add(node2.left);
            }

            if (node2.right != null){
                if (node1.right == null){
                    node1.right = new TreeNode(0);
                }
                queue1.add(node1.right);
                queue2.add(node2.right);
            }
        }

        return t1;



    }

}
