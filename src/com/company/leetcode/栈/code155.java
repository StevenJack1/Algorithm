package com.company.leetcode.栈;

import java.util.Stack;

/**
 *
 */
public class code155 {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> mini_stack;
    public code155() {
        stack = new Stack<>();
        mini_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (mini_stack.isEmpty() || x <= mini_stack.peek()){
            mini_stack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(mini_stack.peek())){
            mini_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mini_stack.peek();
    }
}
