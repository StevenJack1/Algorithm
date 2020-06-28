package com.company.basicStructure.sort;

/**
 * 插入排序
 * 思路：把当前元素与前面的从后往前比较，分别移动
 */
public class Insertion {

    public static void sort(int[] a){
        int len = a.length;
        for (int i=1; i< len;i++){
            int temp = i;
            for (int j = i-1;j >= 0;j--){
                if (a[j] >= a[temp]){
                    Swap.swap(a,j,temp);
                    temp = j;
                }
            }
        }
    }
}
