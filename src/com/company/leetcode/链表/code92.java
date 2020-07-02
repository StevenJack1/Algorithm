package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class code92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode left = sentry;
        ListNode right = sentry.next;

        // 移动left指针到第m个位置的前一个
        int step = 0;
        while (step < m - 1){
            left = left.next;
            right = right.next;
            step++;
        }

        // 使用头插法 改变链表
        for (int i = 0; i < n - m; i++) {
            ListNode remove = right.next;
            right.next = right.next.next;
            remove.next = left.next;
            left.next = remove;
        }
        return sentry.next;
    }
}
