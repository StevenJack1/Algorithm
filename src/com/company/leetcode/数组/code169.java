package com.company.leetcode.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋
 * 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class code169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length/2;

        for (int num:nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }
        for (int key : map.keySet()){
            if (map.get(key) > len){
                return key;
            }
        }
        return res;
    }
}
