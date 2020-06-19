package com.company.leetcode.链表;

import com.company.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class code83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null){
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
