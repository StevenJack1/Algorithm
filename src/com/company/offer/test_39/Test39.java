package com.company.offer.test_39;

/**
 * 面试题38：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1,2, 3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
public class Test39 {


    public static int search(int[] nums, int target) {

        int i = 0,j = nums.length-1;
        while (i <= j){
            int m = i + (j-i)/2;
            if (nums[m] <= target) i = m +1;
            else j = m-1;
        }
        int right = i;

        i = 0;
        j = nums.length-1;
        while (i <= j){
            int m = i + (j-i)/2;
            if (nums[m] < target) i = m +1;
            else j = m-1;
        }
        int left = j;

        return right - left -1;

    }

    public static void main(String[] args) {
        int[] arr = {1,2, 3,3,3,3,4,5};
        System.out.println(search(arr,3));
    }
}
