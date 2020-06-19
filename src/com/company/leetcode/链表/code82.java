package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class code82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode slow = sentry,fast = head;
        // 快慢指针
        while (fast != null && fast.next != null){
            if (fast.val != fast.next.val){
                if (slow.next == fast){
                    slow = fast;
                } else {
                    slow.next = fast.next;
                }
            } else {
                fast = fast.next;
            }
        }
        if (slow.next != fast){
            slow.next = fast.next;
        }
        return sentry.next;
    }
}
