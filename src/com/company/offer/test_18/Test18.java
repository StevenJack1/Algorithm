package com.company.offer.test_18;


import com.company.offer.List.ListNode;

/**
 * 面试题17：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * 例如输入图3.7中的链表1和链表2，则合并之后的升序链表如链表3所示。链表结点定义如下：
 */
public class Test18 {

    public static ListNode test18(ListNode firstList,ListNode secondList){

        if (firstList == null){
            return secondList;
        } else if (secondList == null){
            return firstList;
        }

        ListNode result = new ListNode();
        ListNode cur = result;
        ListNode first = firstList;
        ListNode second = secondList;


        while (first != null && second != null){
            if (first.value < second.value){
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }

        cur.next = (first != null ? first : second);

        while (result.next != null){
            result = result.next;
            System.out.println(result.value);
        }


        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        listNode.value = 1;
        listNode1.value = 3;
        listNode2.value = 5;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = null;

        ListNode second = new ListNode();
        ListNode second1 = new ListNode();
        ListNode second2 = new ListNode();
        second.value = 2;
        second1.value = 4;
        second2.value = 6;
        second.next = second1;
        second1.next = second2;
        second2.next = null;

        test18(listNode,second);

    }

}
