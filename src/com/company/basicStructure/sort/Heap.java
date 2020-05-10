package com.company.basicStructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 思路：一个挺详细的帖子
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class Heap {

    // 步骤一 构造初始堆。将给定无序序列构造成一个大顶堆
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k = 2 * i + 1;k < length;k = 2*k+1){
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    // 步骤二 将堆顶元素与末尾元素进行交换，使末尾元素最大。
    // 然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素。如此反复进行交换、重建、交换。
    public static void sort(int[] arr){
        // 1构建初始堆
        for (int i = arr.length/2 -1;i >=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        // 2调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length-1;j>0;j--){
            Swap.swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
