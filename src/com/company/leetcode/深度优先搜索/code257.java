package com.company.leetcode.深度优先搜索;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class code257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return null;
        }

        // DFS
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(root,String.valueOf(root.val)));
        List<String> res = new LinkedList<>();

        while (!stack.isEmpty()){
            Record cur = stack.pop();
            String path = cur.path;
            TreeNode temp = cur.node;

            if (temp.left != null){
                stack.push(new Record(temp.left,path+"->"+String.valueOf(temp.left.val)));
            }
            if (temp.right != null){
                stack.push(new Record(temp.right,path+"->"+String.valueOf(temp.right.val)));
            }

            // 对于叶子结点把路径放入res
            if (temp.left == null && temp.right == null){
                res.add(path);
            }
        }
        return res;

    }

    class Record {
        TreeNode node;
        String path;

        public Record(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        code257 code257 = new code257() ;
        TreeNode root = new TreeNode(1);
        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(3);
        TreeNode temp3 = new TreeNode(5);
        root.left = temp1;
        root.right = temp2;
        temp1.right= temp3;
        code257.binaryTreePaths(root);
    }

}
