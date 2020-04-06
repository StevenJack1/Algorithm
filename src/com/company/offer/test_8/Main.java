package com.company.offer.test_8;

import java.util.Stack;

/**
 * 面试题8：用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class Main {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void appendTail(int element){
        stack1.push(element);
    }

    public static void deleteHead(){
        int lenght = stack1.size();
        if (lenght > 0){
            for (int i = 0; i < lenght;i++){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() > 0){
            stack2.pop();
        } else {
            System.out.println("没有值啊");
        }

    }

    public static void main(String[] args) {
        appendTail(1);
        appendTail(2);
        appendTail(3);

        deleteHead();

        appendTail(4);

    }
}
