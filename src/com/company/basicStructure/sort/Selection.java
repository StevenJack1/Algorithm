package com.company.basicStructure.sort;


/**
 * 选择排序
 * 思路：找出最小的一个元素，与第一个位置互换，接着指针后移，循环上一步
 */
public class Selection {

    public static void sort(int[] a){
        int len = a.length;
        for (int i = 0;i < len;i++){
            int min = i;
            for (int j = i+1;j < len;j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            Swap.swap(a,i,min);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,12,34,1,7,4,112};
        sort(a);
        for (int c:a){
            System.out.println(c);
        }
    }
}
