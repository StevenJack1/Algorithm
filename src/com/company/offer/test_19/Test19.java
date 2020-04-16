package com.company.offer.test_19;


import com.company.offer.Tree.TreeNode;

/**
 * 面试题18：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。二叉树结点的定义如下：
 */
public class Test19 {

    public static boolean equal(TreeNode A,TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.value != B.value){
            return false;
        }

        return equal(A.leftChild,B.leftChild) && equal(A.rightChild,B.rightChild);
    }

    public static boolean  isSubStructure(TreeNode A, TreeNode B){
        boolean result = false;

        if (A != null && B != null){
            if (A.value == B.value){
                result = equal(A,B);
            }
            if (!result){
                result = isSubStructure(A.leftChild,B);
            }
            if (!result){
                result = isSubStructure(A.rightChild,B);
            }
        }
        return result;
    }

}
