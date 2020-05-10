package com.company.offer.test_34;

import java.util.Arrays;

/**
 * 面试题33：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，
 * 则打印出这3个数字能排成的最小数字321323。
 */
public class Test34 {

    public static String minNumber(int[] nums) {

        String[] str = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:str){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        System.out.println(minNumber(nums));
    }

}
