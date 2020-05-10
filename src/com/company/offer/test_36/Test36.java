package com.company.offer.test_36;


import java.util.HashMap;

/**
 * 面试题35：第一个只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 */
public class Test36 {

    public static char test36(String s){
        if (s.length()==0){
            return ' ';
        }
        char[] arr = s.toCharArray();
        HashMap<Character,Boolean> map = new HashMap<>();

        for (char c:arr){
            map.put(c,!map.containsKey(c));
        }
        for (char c:arr){
            if (map.get(c)){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(test36("abaccdeff"));
    }

}
