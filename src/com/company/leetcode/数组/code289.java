package com.company.leetcode.数组;

import java.util.Arrays;

/**
 * 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
 * 1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）
 * 的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * 进阶：
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，
 * 然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你
 * 将如何解决这些问题？
 */
public class code289 {
    public void gameOfLife(int[][] board) {
        int maxRow = board.length;
        int maxCol = board[0].length;
        int[][] res = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                res[i][j] = judgeNode(i,j,board);
            }
        }
        for(int i = 0;i < res.length;i++){
            board[i] = Arrays.copyOf(res[i],res[i].length);
        }
    }

    public int judgeNode(int curRow,int curCol,int[][] board){
        int maxRow = board.length;
        int maxCol = board[0].length;
        boolean minRowFlag = (curRow-1 >= 0);
        boolean minColFlag = (curCol-1 >= 0);
        boolean maxRowFlag = (curRow+1 < maxRow);
        boolean maxColFlag = (curCol+1 < maxCol);
        int num = getLiveNumber(minRowFlag,minColFlag,maxRowFlag,maxColFlag,board,curRow,curCol);

        if (board[curRow][curCol] == 0){
            if (num == 3){
                return 1;
            }
            return 0;
        }
        if (num < 2 || num > 3){
            return 0;
        } else {
            return 1;
        }

    }

    public int getLiveNumber(boolean minRowFlag,boolean minColFlag,boolean maxRowFlag,boolean maxColFlag,int[][] board,int curRow,int curCol){
        int num = 0;
        if (minRowFlag && minColFlag){
            num = (board[curRow-1][curCol-1] == 1) ? num +1 : num;
        }
        if (minRowFlag){
            num = (board[curRow-1][curCol] == 1) ? num +1 : num;
        }
        if (minColFlag){
            num = (board[curRow][curCol-1] == 1) ? num +1 : num;
        }
        if (minColFlag && maxRowFlag){
            num = (board[curRow+1][curCol-1] == 1) ? num +1 : num;
        }
        if (maxRowFlag){
            num = (board[curRow+1][curCol] == 1) ? num +1 : num;
        }
        if (minRowFlag && maxColFlag){
            num = (board[curRow-1][curCol+1] == 1) ? num +1 : num;
        }
        if (maxColFlag){
            num = (board[curRow][curCol+1] == 1) ? num +1 : num;
        }
        if (maxColFlag && maxRowFlag){
            num = (board[curRow+1][curCol+1] == 1) ? num +1 : num;
        }
        return num;
    }

    public static void main(String[] args) {
        code289 code289 = new code289();
        int[][] borad = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        code289.gameOfLife(borad);
    }
}
