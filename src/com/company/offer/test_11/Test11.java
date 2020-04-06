package com.company.offer.test_11;


/**
 * 面试题10：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class Test11 {

    public static int cal(int n){
        String s = Integer.toBinaryString(n);
        int number = 0;
        for (int i = 0 ;  i < s.length(); i++){
            if (s.charAt(i) == '1'){
                number++;
            }
        }
        return number;
    }


}
