package com.company.leetcode.设计;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：
 * 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:

 */


public class LRUCache {

    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
        public DNode(){}
        public DNode(int _key,int _value){key = _key;value = _value;}
    }

    private Map<Integer,DNode> res = new HashMap<>();
    private int size;
    private int capacity;
    private DNode head,tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode dNode = res.get(key);
        if (dNode == null){
            return -1;
        }
        moveToHead(dNode);
        return dNode.value;
    }

    public void put(int key, int value) {
        DNode node = res.get(key);
        if (node == null) {
            DNode dNode = new DNode(key, value);
            addToHead(dNode);
            res.put(key,dNode);
            size++;
            if (size > capacity){
                DNode temp = removeTail();
                res.remove(temp.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    public void moveToHead(DNode dNode){
        removeNode(dNode);
        addToHead(dNode);
    }

    public void removeNode(DNode dNode){
        dNode.prev.next = dNode.next;
        dNode.next.prev = dNode.prev;
    }

    public void addToHead(DNode dNode){
        dNode.next = head.next;
        head.next.prev = dNode;
        head.next = dNode;
        dNode.prev = head;
    }

    public DNode removeTail(){
        DNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }
}
