package com.company.leetcode.双指针;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class code977 {
    // 双指针
    public int[] sortedSquares(int[] A) {
        int i = 0;
        int len = A.length;
        int[] res = new int[len];
        for (; i < len; i++) {
            if (A[i] >= 0) break;
        }
        int j = i-1;
        int t=0;
        while (j >= 0 && i < len){
            if (A[i] * A[i] > A[j] * A[j]){
                res[t++] = A[j] * A[j];
                j--;
            } else {
                res[t++] = A[i] * A[i];
                i++;
            }
        }
        while (j>=0){
            res[t++] = A[j] * A[j];
            j--;
        }
        while (i < len){
            res[t++] = A[i] * A[i];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        code977 code977 = new code977();
        int[] A = {-3,-2,-1,0,1,2,3,4};
        code977.sortedSquares(A);
    }
}
