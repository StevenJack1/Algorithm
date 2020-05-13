package com.company.offer.test_42;


import java.util.*;

/**
 * 面试题41：和为s的两个数字VS和为s的连续正数序列
 * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，输出任意一对即可。
 * 例如输入数组{1、2、4、7、11、15}和数字 15。由于 4+11=15，因此输出4和11。
 *
 * 题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
 */
public class Test42 {

    // 使用双指针
    public int[] twoSum(int[] nums, int target) {
        if (nums.length==0 || target < 0){
            return null;
        }
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[2];
        while (left <= right){
            if (nums[left] + nums[right] < target){
                left++;
            } else if (nums[left] + nums[right] > target){
                right--;
            } else {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }
        return result;
    }

    // 使用双指针
    public static int[][] findContinuousSequence(int target) {
        if (target < 0){
            return null;
        }
        int left = 1;
        int right = 1;
        int sum = 0;
        int middle = target/2;
        List<int[]> result = new ArrayList<>();
        while (left <= middle){
            if (sum < target){
                sum += right;
                right++;
            } else if (sum > target){
                sum -= left;
                left++;
            } else {
                int[] temp = new int[right-left];
                int i =0;
                int k = left;
                int z = right;
                while (k < z){
                    temp[i] = k;
                    i++;
                    k++;
                }
                result.add(temp);
                sum -= left;
                left++;
            }
        }
        int [][] temp = new int[result.size()][];
        for (int i = 0 ;i < result.size();i++){
            temp[i] = result.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }
}
