package com.company.offer.test_25;


/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 例如输入数组{5,7,6,9,11,10,8}，则返回true，因为这个整数序列是图4.6二叉搜索树的后序遍历结果。
 * 如果输入的数组是{7,4,6,5}，由于没有哪棵二叉搜索树的后序遍历的结果是这个序列，因此返回false。
 */
public class Test25 {

    public static boolean test25(int[] a,int len){

        if (a == null || len <= 0){
            return false;
        }

        int root = a[len-1];

        int i = 0;
        for (; i < len-1;i++){
            if (a[i] > root){
                break;
            }
        }

        int j = i;
        for (; j < len -1;j++){
            if (a[j] < root){
                return false;
            }
        }

        boolean left = true;
        if (i > 0){
            int[] temp = new int[i];
            System.arraycopy(a,0,temp,0,i);
            left = test25(temp,i);
        }

        boolean right = true;
        if (i < len -1){
            int[] temp = new int[len-i-1];
            System.arraycopy(a,i,temp,0,len-i-1);
            right = test25(temp,len-i-1);
        }

        return (right&&left);

    }


    public static void main(String[] args) {
//        int[] a = {5,7,6,9,11,10,8};
        int[] a = {7,4,6,5};
        System.out.println(test25(a,a.length));
    }

}
