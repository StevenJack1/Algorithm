package com.company.offer.test_47;

/**
 * 面试题46：求1+2+…+n
 * 题目：求1+2+…+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Test47 {

    public int sumNums(int n) {
        boolean x= n>1 && (n += sumNums(n-1)) > 0;
        return n;
    }

}
