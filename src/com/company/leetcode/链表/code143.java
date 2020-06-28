package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class code143 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null && slow != null){
            pre.next = null;
            ListNode p = null;
            while (slow != null){
                ListNode next = slow.next;
                slow.next = p;
                p = slow;
                slow = next;
            }

            ListNode restart = head;
            while (restart != null){
                ListNode firstNext = restart.next;
                ListNode secondNext = p.next;

                if (restart.next != null){
                    p.next = restart.next;
                }
                restart.next = p;
                p = secondNext;
                restart = firstNext;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
//        head3.next = null;
        head3.next = head4;
        head4.next = null;
        code143 code143 = new code143();
        code143.reorderList(head);
    }
}
