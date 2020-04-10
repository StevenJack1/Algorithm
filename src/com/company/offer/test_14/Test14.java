package com.company.offer.test_14;

/**
 * 面试题13：在O（1）时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O（1）时间删除该结点。
 * 思路：
 */
public class Test14 {

    public static Node deleteNode(Node headNode,Node deleteNode){

        if (headNode == null || deleteNode == null){
            return null;
        }
        // 不是尾节点
        if (deleteNode.next != null){
            Node nextNode = deleteNode.next;
            deleteNode.value = nextNode.value;
            deleteNode.next = nextNode.next;
            return headNode;
        } else if (headNode == deleteNode){
            return null;
        } else{
            Node p = headNode;
            while (p.next != deleteNode){
                p = p.next;
            }
            p.next = null;
            return p;
        }

    }

    class Node {
        int value;
        Node next;
    }

}
