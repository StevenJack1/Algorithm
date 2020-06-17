package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class code24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;

        while (temp.next != null && temp.next.next != null){
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return res.next;
    }

}
