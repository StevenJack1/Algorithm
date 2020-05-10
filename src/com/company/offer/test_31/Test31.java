package com.company.offer.test_31;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题30：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。
 * 例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Test31 {

    // 第一种思路，快排
    public static int partition(int[] arr,int left,int right){
        int temp = arr[left];

        while (left < right){
            while (left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    public static int[] quickSearch(int[] arr,int left,int right,int k){
        int middle = partition(arr,left,right);
        if (middle == k){
            return Arrays.copyOf(arr,k+1);
        }
        if (middle > k){
            return quickSearch(arr,left,middle-1,k);
        }
        return quickSearch(arr,middle+1,right,k);
    }

//    public static void sort(int[] arr,int left,int right){
//        if (arr.length == 0){
//            return;
//        }
//        if (left < right){
//            int middle = partition(arr,left,right);
//            sort(arr,left,middle-1);
//            sort(arr,middle+1,right);
//        }
//    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || arr.length < k){
            return null;
        }
        return quickSearch(arr,0,arr.length-1,k-1);

//        sort(arr,0,arr.length-1);
//        int[] result = new int[k];
//        for (int i = 0 ; i <k;i++){
//            result[i] = arr[i];
//        }
//        for (int a: result){
//            System.out.println(a);
//        }
//        return null;
    }

    // 第二种 使用大根堆
    public static int[] getLeastNumbers_second(int[] arr, int k) {
        if (arr.length == 0 || arr.length < k){
            return null;
        }
        Queue<Integer> heap = new PriorityQueue<>(k,(i1,i2) -> Integer.compare(i2,i1));

        for (int e:arr){
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()){
                heap.offer(e);
            }
            if (heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8,0};
        int[] leastNumbers = getLeastNumbers_second(arr, 5);
        System.out.println(Arrays.toString(leastNumbers));


    }

}
