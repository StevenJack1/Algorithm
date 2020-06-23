package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

/**
 * 147. 对链表进行插入排序
 *     插入排序算法：  插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *    示例 1：
 *    输入: 4->2->1->3
 *    输出: 1->2->3->4
 *
 *    示例 2：
 *    输入: -1->5->3->4->0
 *    输出: -1->0->3->4->5
 */
public class code147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        while (cur != null){
            if (pre.val <= cur.val){
                pre = cur;
                cur = cur.next;
            } else {
                ListNode temp = sentry;
                while (temp.next != cur && temp.next.val < cur.val){
                    temp = temp.next;
                }
                pre.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;

                cur = pre.next;
            }
        }
        return sentry.next;
    }
}
