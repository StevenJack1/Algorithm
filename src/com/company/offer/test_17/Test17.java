package com.company.offer.test_17;


import com.company.offer.List.ListNode;

/**
 * 面试题16：反转链表
 * 题目：
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。链表结点定义如下：
 */
public class Test17 {

    public static void test17(ListNode headNode){


        ListNode reverseHead = null;
        ListNode firstList = headNode;
        ListNode secondeList = null;

        while (firstList != null){

            ListNode temp = firstList.next;
            if (temp == null){
                reverseHead = firstList;
            }

            firstList.next = secondeList;
            secondeList = firstList;
            firstList = temp;
        }

        while (secondeList.next != null){
            System.out.println(secondeList.value);
        }

    }


}
