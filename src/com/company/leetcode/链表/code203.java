package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 */
public class code203 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null){
            return null;
        }
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode prev = sen;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return sen.next;

    }

}
