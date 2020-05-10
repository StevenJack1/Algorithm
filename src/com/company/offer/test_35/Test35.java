package com.company.offer.test_35;

/**
 * 面试题34：丑数
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做第一个丑数。
 */
public class Test35 {

    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i =1;i<n;i++){
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;

            dp[i] = Math.min(n2,Math.min(n3,n5));
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n-1];
    }


}
