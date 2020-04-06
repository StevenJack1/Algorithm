package com.company.offer.test_6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题5：从尾到头打印链表题目：
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Main {

    // 使用栈的思路
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> objects = new LinkedList<>();

        while (head != null){
            objects.add(head.val);
            head = head.next;
        }

        int[] ints = new int[objects.size()];
        for (int i = 0; i< ints.length;i++){
            ints[i] = objects.removeLast();
        }

        return ints;
    }

    // 使用递归的思路
    static ArrayList<Integer> tmp = new ArrayList<Integer>();
    public static int[] reversePrint2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        return res;
    }

    public static void recur(ListNode head){
        if(head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        int[] ints = reversePrint(head);

    }

}
