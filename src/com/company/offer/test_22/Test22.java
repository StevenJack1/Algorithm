package com.company.offer.test_22;


import netscape.security.UserTarget;

import java.util.Stack;

/**
 *面试题21：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O（1）。
 */
public class Test22 {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void push(int value){

        stack.push(value);

        if (minStack.isEmpty()){
            minStack.push(value);
        } else if (value < minStack.peek()){
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public static void pop(){
        if (minStack.isEmpty() && stack.isEmpty()){
            return ;
        }
        stack.pop();
        minStack.pop();
    }

    public static int min(){
        if (minStack.isEmpty() && stack.isEmpty()){
            return -1;
        }
        return minStack.peek();
    }

}
