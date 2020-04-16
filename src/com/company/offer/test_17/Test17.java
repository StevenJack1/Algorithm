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

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        listNode.value = 1;
        listNode1.value = 2;
        listNode2.value = 3;
        listNode3.value = 4;
        listNode4.value = 5;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        test17(listNode);


    }

}
