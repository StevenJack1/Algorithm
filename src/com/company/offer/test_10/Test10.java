package com.company.offer.test_10;

/**
 * 面试题9：斐波那契数列
 * 题目一：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：
 */
public class Test10 {

    public static int cal(int n){
        int one = 0;
        int two = 1;
        int temp = 0;
        if (n == 0){
            return one;
        }
        if (n == 1){
            return two;
        }

        for (int i = 2; i <= n; i++){
            temp = one + two;
            one = two;
            two = temp;
        }
        return temp;
    }

}
