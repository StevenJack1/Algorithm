package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，
 * 这太糟糕了。
 */
public class code226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
        }
        return root;
    }
}
