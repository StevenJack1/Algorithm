package com.company.leetcode.深度优先搜索;

import com.company.leetcode.ListNode;
import com.company.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class code109 {

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null){
            pre.next = null;
        }
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    // 第二种方法数组+递归
    public TreeNode sortedListToBST_second(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null){
            arr.add(head.val);
            head = head.next;
        }
        return toBST(arr,0,arr.size() - 1);
    }

    public TreeNode toBST(List<Integer> arr,int left,int right){
        if (left > right){
            return null;
        }
        int mid = left + (right - left)/2 ;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = toBST(arr,left,mid-1);
        root.right = toBST(arr,mid+1,right);
        return root;
    }




}
