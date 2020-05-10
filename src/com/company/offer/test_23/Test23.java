package com.company.offer.test_23;


import java.util.Stack;

/**
 * 面试题22：栈的压入、弹出序列
 * 题目：输入两个整数序列，
 * 第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1、2、3、4、5 是某栈的压栈序列，
 * 序列4、5、3、2、1 是该压栈序列对应的一个弹出序列，但 4、3、5、1、2 就不可能是该压栈序列的弹出序列。
 */
public class Test23 {

    public static boolean test23(int[] a,int[] b){
        Stack<Integer> stack = new Stack<>();
        if (a.length == 0 || b.length ==0){
            System.out.println(false);
            return false;
        }
        int index = 0;
        int len = a.length;
        for (int i = 0 ; i < len;i ++){
            stack.push(a[i]);

            while (!stack.isEmpty() && index < len && b[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        System.out.println(stack.isEmpty());
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        test23(a,b);
    }

}
