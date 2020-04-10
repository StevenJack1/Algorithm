package com.company.offer.test_16;

import com.company.offer.List.ListNode;

/**
 * 面试题15：链表中倒数第k个结点
 * 题目：输入一个链表，
 * 输出该链表中倒数第 k 个结点。为了符合大多数人的习惯，本题从1 开始计数，
 * 即链表的尾结点是倒数第1 个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是值为4的结点。
 */
public class Test116 {

    public static ListNode test16(ListNode headNode,int k){
        if (k <= 0 || headNode == null){
            return null;
        }

        ListNode firstNode = headNode;
        ListNode secondNode = headNode;

        for (int i=0;i<(k-1);i++){
            if (firstNode.next != null){
                firstNode = firstNode.next;
            } else {
                return null;
            }
        }

        while (firstNode.next != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }

}
