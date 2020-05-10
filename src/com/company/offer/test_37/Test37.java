package com.company.offer.test_37;

/**
 * 面试题36：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 例如在数组{7,5,6,4} 中，一共存在5个逆序对，分别是（7,6）、（7,5）、（7,4）、（6,4）和（5,4）。
 */
public class Test37 {
    /**
     * 利用归并排序的思路
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums){
        int len = nums.length;
        if (len <2){
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];

        return reversePairs(copy,0,len-1,temp);
    }

    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left==right){
            return 0;
        }

        int mid = left + (right-left)/2;
        int leftNumber = reversePairs(nums,left,mid,temp);
        int rightNumber = reversePairs(nums,mid+1,right,temp);
        if (nums[mid] <= nums[mid+1]){
            return leftNumber+rightNumber;
        }

        int crossNumber = mergeAndCount(nums,left,mid,right,temp);
        return leftNumber+rightNumber+crossNumber;

    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid+1;
        int count = 0;

        for (int k = left; k <= right; k++) {
            if (i == mid+1){
                nums[k] = temp[j];
                j++;
            } else if (j == right+1){
                nums[k] = temp[i];
                i++;
            } else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        System.out.println(reversePairs(arr));
    }

}
