package com.company.leetcode.图;

import java.util.*;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，
 * 在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，
 * 写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表
 * （每一个边都是一对标签）。
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边，
 * [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * 示例 1:
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * 输出: [1]
 *
 * 示例 2:
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 * 输出: [3, 4]
 *
 * 说明:
 * 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接.换句话说，
 * 一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class leetcode310 {

    /**
     * BFS来剪出叶子结点
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new LinkedList<>();

        if (n == 1){
            res.add(0);
            return res;
        }

        // 初始化图和度
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i,new HashSet<>());
        }
        for (int[] temp: edges){
            degree[temp[0]]++;
            degree[temp[1]]++;
            graph.get(temp[0]).add(temp[1]);
            graph.get(temp[1]).add(temp[0]);
        }

        // 把度为1的节点入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1){
                queue.offer(i);
            }
        }

        // 一次性循环剪出叶子结点
        while (!queue.isEmpty()){
           res = new LinkedList<>();
           int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);

                // BFS
                Set<Integer> nei = graph.get(cur);
                for (int temp:nei){
                    degree[temp]--;
                    if (degree[temp] == 1){
                        queue.offer(temp);
                    }
                }
            }
        }



        return res;

    }

    public static void main(String[] args) {
        leetcode310 leetcode310 = new leetcode310();
        int[][] array = {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}};

        System.out.println(leetcode310.findMinHeightTrees(6,array).toString());
    }

}
