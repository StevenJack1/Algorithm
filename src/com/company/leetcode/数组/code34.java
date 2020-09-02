package com.company.leetcode.数组;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class code34 {

    public static int binarySearch(int[] array,int item){
        int low = 0;
        int high = array.length -1;
        int middle = 0;
        while (low <= high){
            middle = (low + high)/2 ;
            if (array[middle] > item){
                high = middle - 1;
            }else if (array[middle] < item){
                low = middle + 1;
            } else {
                break;
            }

        }
        return middle;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }
        int index = binarySearch(nums, target);
        int[] res = new int[2];
        if (nums[index] != target){
            return new int[] {-1,-1};
        }
        int left = index;
        int right = index;


        for (int i = left; i >=0 ; i--) {
            if (nums[i] == nums[left]) left = i;
            else break;
        }
        for (int i = right; i < nums.length; i++) {
            if (nums[i] == nums[right]) right = i;
            else break;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        new code34().searchRange(nums,6);
    }
}
