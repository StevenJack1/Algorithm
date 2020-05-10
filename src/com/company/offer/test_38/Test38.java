package com.company.offer.test_38;

import com.company.offer.List.ListNode;

import java.util.Stack;

/**
 * 面试题37：两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。链表结点定义如下：
 */
public class Test38 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (headA != null){
            stackA.push(headA);
            headA = headA.next;
        }

        while (headB != null){
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()){
            if (stackA.peek() == stackB.peek()){
                result = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return result;
    }

    public static ListNode getIntersectionNode_second(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB){
            tempA = (tempA != null) ? tempA.next : headB;
            tempB = (tempB != null) ? tempB.next : headA;
        }
        System.out.println(tempA.value);
        return tempA;


    }

        public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headA1 = new ListNode(2);
        ListNode headA2 = new ListNode(4);
        headA.next = headA1;
        headA1.next = headA2;

        ListNode headB = new ListNode(3);
        ListNode headB1 = new ListNode(2);
        ListNode headB2 = new ListNode(4);
        headB.next = headB1;
        headB1.next = headB2;

        getIntersectionNode_second(headA,headB);

    }

}
