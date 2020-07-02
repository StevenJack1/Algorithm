package com.company.leetcode.数组;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class code215 {

    public int pagination(int[] nums,int left,int right){
        int temp = nums[left];
        while (left < right){
            while (left < right && temp <= nums[right]){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && temp > nums[left]){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    public int findKthLargest(int[] nums, int k) {
        // 对数组进行快排
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - k;

        while (true){
            int mid = pagination(nums,left,right);
            if (mid == index){
                return nums[index];
            } else if (mid > index){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
