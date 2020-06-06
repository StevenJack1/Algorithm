package com.company.leetcode.数组;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class code128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for (int temp:nums){
            set.add(temp);
        }
        int max = 0;

        for (int temp:set){
            if (!set.contains(temp-1)){
                int curNum = temp;
                int len = 1;

                while (set.contains(curNum+1)){
                    curNum += 1;
                    len += 1;
                }

                max = Math.max(len,max);
            }
        }
        return max;


    }

}
