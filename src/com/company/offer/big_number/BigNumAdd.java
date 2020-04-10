package com.company.offer.big_number;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 大数相加
 * 思路：利用双栈存数，利用数组来获取相加结果
 */
public class BigNumAdd {

    public static String add(String s1,String s2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int len1 = s1.length();
        int len2 = s2.length();

        int len = (len1 > len2) ? len1+1 : len2+1;

        int[] result = new int[len];
        int t =0;

        for (int i = 0;i < len1;i++){
            stack1.push((int)s1.charAt(i) -48);
        }

        for (int i = 0;i < len2;i++){
            stack2.push((int)s2.charAt(i) -48);
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            result[t++]  = (stack1.pop() + stack2.pop());
        }

        while (!stack1.isEmpty()){
            result[t++] = stack1.pop();
        }
        while (!stack2.isEmpty()){
            result[t++] = stack2.pop();
        }

        for (int i = 0;i < len;i++){
            int current = result[i];
            int step = 0;
            int change = 0;
            if (current > 9){
                step = current/10;
                change = current % 10;
                result[i] = change;
                result[i+1] += step;
            }
        }
        String str = "";
        if (result[len-1] != 0){
            str += result[len-1];
        }
        for (int i = len-2; i >=0;i--){
            str += result[i];
        }
        return str;

    }

    public static void main(String[] args) {
        String s1 = "123456789";
        String s2 = "456789";
        System.out.println(add(s1,s2));
    }

}
