package com.company.leetcode.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x
 * 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class code11 {
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null){
            return -1;
        }
        int left = 0;
        int right = height.length-1;

        while (left < right){
            int temp = (right - left) * Math.min(height[left],height[right]);
            res = Math.max(temp,res);
            int i = Math.min(height[left], height[right]) == height[left] ? left++ : right--;

        }
        return res;
    }
}
