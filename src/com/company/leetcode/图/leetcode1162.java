package com.company.leetcode.图;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）
 * 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，
 * 这个海洋区域到离它最近的陆地区域的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 
 * 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 */
public class leetcode1162 {

    /**
     * 广度优先遍历
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        // 二维数组中横扫四周
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        // 初始化,把陆地加入到队列中
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    queue.add(new int[] {i,j});
                }
            }
        }

        // 广度遍历海洋
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0],y = point[1];
            // 四周遍历
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX][newY] != 0){
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[] {newX,newY});
            }
        }
        if (point == null || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]] -1;

    }

    public static void main(String[] args) {
        leetcode1162 a = new leetcode1162();
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        a.maxDistance(grid);
    }

}
