package com.company.offer.test_30;


import java.util.HashMap;
import java.util.Map;

/**
 * 面试题29：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。
 */
public class Test30 {

    static Map<Integer,Integer> map = new HashMap<>();

    public static int majorityElement(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        int middleNum = nums.length >> 1;

        for (int data : nums){
            if (map.containsKey(data)){
                map.put(data,map.get(data)+1);
            }else {
                map.put(data,1);
            }
        }
        int maxKey = nums[0];
        for (Integer key : map.keySet()){
            if (map.get(key) > map.get(maxKey)){
                maxKey = key;
            }
        }
        if (map.get(maxKey) < middleNum){
            return -1;
        }
        return maxKey;
    }

    // 方法二：摩尔投票法  抵消原则
    public int majorityElement_second(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums){
            if(num == x) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        majorityElement(nums);
    }

}
