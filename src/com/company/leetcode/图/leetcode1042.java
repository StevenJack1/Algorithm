package com.company.leetcode.图;

import java.util.*;

/**
 * 1042. 不邻接植花
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的
 * 种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *
 *  
 *
 * 示例 1：
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 *
 * 示例 3：
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *  
 * 提示：
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 *
 */
public class leetcode1042 {

    /**
     * 思路：
     * 首先初始化出一个图，图的数据结构为Map<Integer,Set<Integer>>
     * 之后查看当前节点的邻近节点的颜色
     * 之后为当前节点染色
     * @param N
     * @param paths
     * @return
     */
    public static int[] gardenNoAdj(int N, int[][] paths) {
        if (N > 10000 || N < 1 || paths.length > 20000 || paths.length < 0){
            return null;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1 ;i <= N;i++){
            graph.put(i,new HashSet<>());
        }
        for (int[] temp:paths){
            graph.get(temp[0]).add(temp[1]);
            graph.get(temp[1]).add(temp[0]);
        }
        int[] res = new int[N+1];
        for (int i = 1; i <= N; i++) {
            boolean[] used = new boolean[5];
            // 查看邻近节点用了什么颜色，把那个颜色设置为true
            for (int temp:graph.get(i)){
                used[res[temp]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!used[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(res,1,N+1);
    }

    public static void main(String[] args) {
        int[][] trust = {{1,2},{2,3},{3,1}};
        gardenNoAdj(3,trust);
    }
}
