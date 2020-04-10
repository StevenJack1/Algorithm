package com.company.offer.test_15;

import com.company.basicStructure.sort.Swap;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Test15 {

    public static void test15(int[] a){
        if (a ==null){
            return;
        }
        int len = a.length;
        int left = 0;
        int right = len - 1;

        while (left < right){
            // (n & 1) == 1 操作代表 判断是否为奇数
            while (left<right && (a[left] & 1) == 1){
                left++;
            }
            while (left<right && (a[right] & 1) == 0){
                right--;
            }
            Swap.swap(a,left,right);
        }


    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        test15(a);

        for (int c:a){
            System.out.println(c);
        }
    }

}
