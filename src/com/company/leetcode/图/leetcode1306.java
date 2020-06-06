package com.company.leetcode.图;

import java.util.*;

/**
 * 1306. 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。
 * 当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *
 * 示例 1：
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 *
 * 示例 2：
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 *
 * 示例 3：
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *  
 *
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 *
 */
public class leetcode1306 {

    // BFS的方法
    public boolean canReach(int[] arr, int start) {
        if (arr.length==0 || start < 0 || start >= arr.length){
            return false;
        }
        if (arr[start] ==0){
            return true;
        }
        // 队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        // 标记访问数组
        boolean[] used = new boolean[arr.length];
        used[start] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> temp = new LinkedList<>();
            temp.add(cur + arr[cur]);
            temp.add(cur - arr[cur]);

            for (int v : temp){
                if (v >=0 && v < arr.length && !used[v]){
                    if (arr[v] == 0){
                        return true;
                    }
                    used[v] = true;
                    queue.add(v);
                }
            }
        }
        return false;
    }

    // DFS方法
    public boolean canReach_dfs(int[] arr, int start) {
        boolean[] visit = new boolean[arr.length];
        return dfs(arr,start,visit);
    }

    public boolean dfs(int[] arr,int start,boolean[] visit){
        if (start < 0 || start >= arr.length || visit[start]){
            return false;
        }
        if (arr[start] == 0){
            return true;
        }
        visit[start] = true;
        int left = start - arr[start];
        if (left >= 0 && !visit[left] && dfs(arr,left,visit)){
            return true;
        }
        int right = start + arr[start];
        if (right < arr.length && !visit[right] && dfs(arr,right,visit)){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        leetcode1306 leetcode1306 = new leetcode1306();
        int[] arr = {4,2,3,0,3,1,2};
        leetcode1306.canReach(arr,5);
    }


}
