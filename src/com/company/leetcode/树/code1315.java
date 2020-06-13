package com.company.leetcode.树;

import com.company.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1315. 祖父节点值为偶数的节点和
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 示例：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *  
 *
 * 提示：
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 */
public class code1315 {

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                if (cur.val % 2== 0){
                    if (cur.left.left != null){
                        res += cur.left.left.val;
                    }
                    if (cur.left.right != null){
                        res += cur.left.right.val;
                    }
                }
            }
            if (cur.right != null){
                queue.add(cur.right);
                if (cur.val % 2== 0){
                    if (cur.right.right != null){
                        res += cur.right.right.val;
                    }
                    if (cur.right.left != null){
                        res += cur.right.left.val;
                    }
                }
            }

        }
        return res;
    }

}
