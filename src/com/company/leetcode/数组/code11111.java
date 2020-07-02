package com.company.leetcode.数组;

import java.util.Stack;

public class code11111 {

    public String reverse (String str) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char temp:str.toCharArray()){
            stack.push(temp);
        }
        String res = "";
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
