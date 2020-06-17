package com.company.leetcode.数组;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target
 * （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 *
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 *
 * 示例 2：
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 * 提示：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 */
public class code1300 {

    public int findBestValue(int[] arr, int target) {
        if (arr == null || target <= 0){
            return -1;
        }
        int res = 0;
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 1 ; i <= arr[len-1];i++){
            int value = i;
            // 使用二分查找早到最小值
            int index = binarySerach(arr, value);
            System.out.println(index);

        }

        return res;
    }

    public int binarySerach(int[] arr , int value){
        int low = 0;
        int high = arr.length-1;
        int middle = 0;
        while (low < high){
            middle = low + (high - low) / 2;
            if (arr[middle] > value){
                high = middle-1;
            } else if (arr[middle] <= value){
                low = middle+1;
            } else {
                return middle;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        code1300 code1300 = new code1300();
        int[] arr = {3,4,9};
        code1300.binarySerach(arr,9);
    }
}
