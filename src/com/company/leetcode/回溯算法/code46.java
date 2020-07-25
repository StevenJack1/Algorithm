package com.company.leetcode.回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class code46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(nums,new LinkedList<>(),res);
        return res;
    }

    public void backTrack(int[] nums,List<Integer> temp,List<List<Integer>> res){
        if (temp.size() == nums.length){
            res.add(new LinkedList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(nums,temp,res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
