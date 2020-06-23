package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class code86 {

    public ListNode partition(ListNode head, int x) {
        ListNode mini_head = new ListNode(-1);
        ListNode mini = mini_head;
        ListNode maxi_head = new ListNode(-1);
        ListNode maxi = maxi_head;

        while (head != null){
            if (head.val < x){
                mini.next = new ListNode(head.val);
                mini = mini.next;
            } else {
                maxi.next = new ListNode(head.val);
                maxi = maxi.next;
            }
            head = head.next;
        }
        mini.next = maxi_head.next;
        return mini_head.next;
    }
}
