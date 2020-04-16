package com.company.offer.test_21;


import java.util.Arrays;

/**
 * 面试题20：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如：如果输入如下矩阵：
 * [1 2 3 4
 *  5 6 7 8
 *  9 10 11 12
 *  13 14 15 16]
 *  则依次打印出数字1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10。
 */
public class Test21 {

    public static void test21(int[][] a){
        int left = 0;
        int right = a[0].length - 1;
        int top = 0;
        int bottom = a.length - 1;

        int[] result = new int[(right+1)*(bottom+1)];
        int t = 0;

        while (true){
            // 第一步从左到右
            for (int i = left;i <= right; i++){
                result[t++] = a[top][i];
            }
            if (++top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++){
                result[t++] = a[i][right];
            }
            if (left > --right){
                break;
            }
            for (int i = right; i >= left;i--){
                result[t++] = a[bottom][i];
            }
            if (top > --bottom ){
                break;
            }
            for (int i = bottom;i >= top; i--){
                result[t++] = a[i][left];
            }
            if (++left > right){
                break;
            }
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[][] a = {{1 ,2 ,3 ,4},{5 ,6 ,7 ,8},{9 ,10 ,11 ,12},{13 ,14 ,15 ,16}};
        test21(a);
    }

}
