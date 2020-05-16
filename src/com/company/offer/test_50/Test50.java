package com.company.offer.test_50;

import com.company.offer.Tree.TreeNode;

/**
 * （面试题50）树中两个结点的最低公共祖先
 */
public class Test50 {

    /**
     * 二叉搜索树的最近公共祖先
     * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p == root || q==root){
            return root;
        }
        while (root != null){
            if (p.value < root.value && q.value < root.value) root = root.leftChild;
            else if (p.value > root.value && q.value > root.value) root = root.rightChild;
            else break;
        }
        return root;
    }

    /**
     *  普通二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor_second(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.leftChild, p, q);
        TreeNode right = lowestCommonAncestor(root.rightChild, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
