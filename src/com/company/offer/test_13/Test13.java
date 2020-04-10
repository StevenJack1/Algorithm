package com.company.offer.test_13;

/**
 * 面试题12：打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 */
public class Test13 {
    public static boolean equal(double base,double other){
        if ((base - other > -0.0000001) && (base -other < 0.0000001)){
            return true;
        }
        return false;
    }


    public static double pow(double base,int exe){
        long exe1 = exe;

        if (equal(base,0) || equal(base,1)){
            return base;
        }
        if (exe1 == 0){
            return 1;
        }
        if (exe1 < 0){
            base = 1/base;
            exe1 = (-1)*exe1;
        }
        double weight = 1.0;
        while (exe1 != 0){
            if ((exe1&1)==1){
                weight *= base;
            }
            base *= base;
            exe1 >>= 1;
        }

        return weight;
    }

    public static int[] printNumbers(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 9 * pow(10, i);
        }

        int[] res = new int[ans];
        for (int i = 0; i < ans; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] ints = printNumbers(3);
//        for ( int int1:ints){
//            System.out.println(int1);
//        }

        System.out.println(pow(2,5));

    }

}



