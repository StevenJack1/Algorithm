package com.company.offer.test_27;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题26：复杂链表的复制
 * 题目：请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Test27 {
    /**
     * 方法一： 借助辅助hashmap来实现
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();

        Node p = head;
        while (p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }

        p = head;

        while (p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public static void first(Node head){
        while (head != null){
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
    }

    public static void second(Node head){
        while (head != null){
            Node cloneNode = head.next;
            if (head.random != null){
                Node temp = head.random;
                cloneNode.random = temp.next;
            }
            head = cloneNode.next;
        }
    }

    public static Node third(Node head){
        Node cloneNode = head.next;
        Node cloneHead = cloneNode;
        head.next = cloneNode.next;
        head = head.next;
        while(head!=null){
            cloneNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }

    public static Node copyRandomList_second(Node head){
        first(head);
        second(head);
        return third(head);
    }


    public static void main(String[] args) {
        Node head = new Node(7);
        Node node = new Node(13);
        Node node1 = new Node(11);
        Node node2 = new Node(10);
        Node node3 = new Node(1);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        head.random = null;
        node.random = head;
        node1.random = node3;
        node2.random = node1;
        node3.random = head;


        copyRandomList(head);


    }

}
