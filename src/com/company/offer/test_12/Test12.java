package com.company.offer.test_12;

/**
 * 面试题12：数值的整数次方
 * 题目：实现函数 double Power（double base, int exponent），
 * 求 base 的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Test12 {

    public static boolean equal(double base,double other){
        if ((base - other > -0.0000001) && (base - other < 0.0000001)){
            return true;
        } else {
            return false;
        }
    }

    public static double power(double base,int exponent){
        if (equal(base,0.0)){
            return 0;
        }
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        if (exponent % 2 ==0){
            double temp = power(base,exponent/2);
            return temp*temp;
        } else {
            double temp = power(base,exponent/2);
            if (exponent < 0){
                base = 1/base;
            }
            return temp*temp*base;
        }


    }



}
