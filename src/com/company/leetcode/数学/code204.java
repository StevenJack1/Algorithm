package com.company.leetcode.数学;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class code204 {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            int flag = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                count++;
            }
        }
        return count;
    }
}
