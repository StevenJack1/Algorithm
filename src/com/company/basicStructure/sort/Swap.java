package com.company.basicStructure.sort;

/**
 * 把数组的两个值交换位置
 */
public class Swap {
    public static void swap(int[] a,int i,int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
}
