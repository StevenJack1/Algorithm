package com.company.basicStructure.sort;

import java.util.Random;

/**
 * 快速排序：
 * 思路：先将数组分解，随机选取一个数作为基础元素base，之后利用双指针，
 * 大于base的放到后面，小于base的放在前面。之后在分别对左边和右边的子数组来分解。
 */
public class Quick {

    public static int partition(int[] a,int left,int right){
        // 从数组中随机选取一个
        Random random = new Random();
        int index = random.nextInt(right) % (right-left+1) + left;
        Swap.swap(a,index,left);

        int temp = a[left];
        while (left< right){
            while (a[right] >= temp && left < right){
                right--;
            }
            a[left] = a[right];
            while (a[left] < temp && left < right){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }


    public static void sort(int[] a,int left,int right){
        if (left < right){
            int middle = partition(a,left,right);
            sort(a,left,middle-1);
            sort(a,middle+1,right);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,12,34,1,7,4,112};
        sort(a,0,a.length-1);
        for (int c:a){
            System.out.println(c);
        }
    }

}
