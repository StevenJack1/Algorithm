package com.company.leetcode.数组;

import java.util.*;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 */
public class code56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null){
            return null;
        }
        if (intervals.length == 1){
            return intervals;
        }
        List<int[]> res = new ArrayList<>();

        //排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        boolean flag = false;
        int prev_num = 0;
        int prev_index = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (flag == false){
                prev_num = intervals[i-1][1];
                prev_index = intervals[i - 1][0];
            }

            // 当前一个值小于当前值，没有交集
            if (prev_num < intervals[i][0]){
                int[] temp = {prev_index,prev_num};
                res.add(temp);
                flag = false;

                if (i == intervals.length-1){
                    addRes(intervals[i][0],intervals[i][1],res);
                }
            }
            // 当前一个值在那个区间里面
            if (prev_num >= intervals[i][0] && prev_num <= intervals[i][1]){
                prev_num = intervals[i][1];
                flag = true;

                if (i == intervals.length-1){
                    addRes(prev_index,prev_num,res);
                }
            }
            // 当前一个值大于那个区间
            if (prev_num > intervals[i][1]){
                flag = true;
                if (i == intervals.length-1){
                    addRes(prev_index,prev_num,res);
                }
            }
        }
        return res.toArray(new int[0][0]);
    }

    public void addRes(int num1,int num2,List<int[]> res){
        int[] temp = {num1,num2};
        res.add(temp);
    }


    public static void main(String[] args) {

        //二维数组
        int[][] matrix = new int[][] {
                {1,3},{2,6},{8,10},{15,18}
        };

        int[][] merge = new code56().merge(matrix);

        //打印
        for(int[] integers : merge){
            System.out.println(Arrays.toString(integers));
        }
    }

}
