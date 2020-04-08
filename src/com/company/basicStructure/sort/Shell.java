package com.company.basicStructure.sort;

/**
 * 希尔排序
 * 思路：插入排序的变形，增加一个步长操作。
 */
public class Shell {

    /**
     * 步长公式
     * @param d
     * @return
     */
    public static int step(int d){
        return d/2;
    }

    public static void sort(int[] a){
        int len = a.length;
        for (int d = step(len); d > 0; d = step(d)){
            for (int i = d; i < len; i++){
                for (int j = i-d; j >=0; j = j-d){
                    if (a[j] > a[j+d]){
                        Swap.swap(a,j,j+d);
                    }
                }
            }
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
