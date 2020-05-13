package com.company.offer.test_44;

/**
 * 面试题43：n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 */
public class Test44 {

    public double[] twoSum(int n) {


        if(n <1 || n > 11){
            return new double[0];
        }
        //总共的数目（6n - n + 1) = 5n+1;
        double[] result = new double[5*n+1];
        //存储投完n个骰子后，某个数出现的次数
        //这里调整数组大小，因为默认是0开始
        //dp[i][j]:投完i个骰子，j出现的次数
        int[][] dp = new int[n+1][5*n+1+n];



        for(int i=1;i<=6;i++){
            dp[1][i] = 1;
        }

        //骰子的数目
        for(int i=2;i<=n;i++){
            //出现的数字，骰子最小都是1，最大都是6
            //所以最小数是骰子的数目，最大是6*n
            for(int j= i;j<=6*i;j++){
                for(int k=1;k<=6;k++){
                    //当前只可能有六个数，那么加上前面减去当前出现的数的次数叠加即可，
                    //就知道投完n个骰子出现的次数
                    //其最小出现的为1；所以0的时候跳出循环
                    if(j-k <= 0){
                        break;
                    }
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        //计算概率
        double all = Math.pow(6,n);
        for(int i=n;i<=6*n;i++){
            result[i-n] = (dp[n][i]/all);
        }

        return result;
    }

}
