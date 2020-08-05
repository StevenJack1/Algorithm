package com.company.leetcode.数组;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，
 * 那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class code581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] other = nums.clone();
        Arrays.sort(other);
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (other[i] != nums[i]){
                left = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (other[i] != nums[i]){
                right = i;
                break;
            }
        }
        return right > left ? right-left+1 : 0;
    }

    public static void main(String[] args) {
        int[] ints = new int[2];
        new code581().findUnsortedSubarray(ints);
    }
}
