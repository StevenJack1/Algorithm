package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 * 示例：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * 提示：
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class code1302 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null){
            return -1;
        }
        int maxDepth = 0;
        int res = 0;

        Stack<Record> stack = new Stack<>();
        Record record = new Record(root,1);
        stack.push(record);

        while (!stack.isEmpty()){
            Record cur = stack.pop();
            TreeNode node = cur.node;
            int depth = cur.depth;


            if (node.left != null){
                stack.push(new Record(node.left,depth + 1));
            }

            if (node.right != null){
                stack.push(new Record(node.right,depth + 1));
            }

            if (node.left == null && node.right == null){
                if (maxDepth < depth){
                    maxDepth = depth;
                    res = 0;
                    res += node.val;
                } else if (maxDepth == depth){
                    res += node.val;
                }
            }


        }


        return res;
    }

    public int deepestLeavesSum_BFS(TreeNode root) {
        if (root == null){
            return -1;
        }
        int res = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int curSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curSum += cur.val;
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            res = curSum;
        }

        return res;

    }


        class Record {
        TreeNode node;
        int depth;
        Record(TreeNode node , int depth){
            this.node = node;
            this.depth = depth;
        }
    }

}
