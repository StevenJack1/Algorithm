package com.company.offer.test_32;

/**
 * 面试题31：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O（n）。
 */
public class Test32 {

    // 方法一，利用数组的特性
    static boolean invalidInput = false;
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            invalidInput = true;
            return 0;
        }
        int result = 0;
        int preResult = nums[0];
        for (int i : nums){
            if (result <= 0){
                result = i;
            } else {
                result += i;
            }
            if (result > preResult){
                preResult = result;
            }
        }
        return preResult;
    }

    /** 第二种方法：动态规划法
     *  1.状态定义：
     *  设动态规划列表dp，dp[i]代表以元素nums[i]为结尾的连续子数组最大和。
     *  为何定义最大和 dp[i]中必须包含元素 nums[i]：保证 dp[i]递推到dp[i+1]的正确性；如果不包含nums[i]，递推时则不满足题目的连续子数组要求。
     *  2.转移方程：
     *  若dp[i−1]≤0，说明dp[i−1]对dp[i]产生负贡献，即dp[i-1] + nums[i]还不如nums[i]本身大。
     *  当 dp[i - 1] > 0时：执行 dp[i] = dp[i-1] + nums[i]；
     *  当 dp[i - 1] <= 0时：执行 dp[i] = nums[i]；
     *  3.初始状态： dp[0] = nums[0]，即以 nums[0]结尾的连续子数组最大和为nums[0] 。
     *  4.返回值： 返回 dp列表中的最大值，代表全局最大值。
     */
    public static int maxSubArray_second(int[] nums) {
        int result = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (nums[i-1] >= 0){
                nums[i] += nums[i-1];
            } else {
                nums[i] += 0 ;
            }
            if (result > nums[i]){
                result = result;
            } else {
                result = nums[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }


}
