package com.company.leetcode.回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class code78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(nums,0,new LinkedList<>(),res);
        return res;
    }

    public void backTrack(int[] nums,int start,List<Integer> temp,List<List<Integer>> res){
        res.add(new LinkedList<>(temp));
        for(int i = start;i < nums.length; i++){
            temp.add(nums[i]);
            backTrack(nums,i+1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args){
        int[] nums={1,2,3};
        (new code78()).subsets(nums);
    }

}
