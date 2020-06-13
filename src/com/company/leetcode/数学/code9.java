package com.company.leetcode.数学;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class code9 {

    public boolean isPalindrome(int x) {

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        int temp = x;
        while (temp != 0){
            queue.add(temp%10);
            stack.push(temp%10);
            temp = temp / 10;
        }
        while (!queue.isEmpty() && !stack.isEmpty()){
            if (!queue.poll().equals(stack.pop())){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        code9 code9 = new code9();
        code9.isPalindrome(1234);
    }

}
