package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class code148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;

        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = (left != null) ? left : right;
        return sentry.next;
    }

}
