package com.company.offer.test_46;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题45：圆圈中最后剩下的数字
 * 题目：0,1,…,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class Test46 {

    // 解法一：环形链表
    public static int lastRemaining(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        // 初始化
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1){
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public static int lastReamining_second(int m ,int n){
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static int lastReamining_3(int n ,int m){
        return f(n,m);
    }

    private static int f(int n, int m) {
        if (n==0){
            return 0;
        }
        int x = f(n-1,m);
        return (m+x)%n;
    }

    public static void main(String[] args) {
        lastReamining_3(5,3);
    }
}
