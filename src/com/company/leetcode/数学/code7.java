package com.company.leetcode.数学;

import java.math.BigDecimal;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class code7 {
    public int reverse(int x) {
        if (x ==0 ){
            return 0;
        }
        int flag = 0;
        if (x < 0){
            flag = 1;
            x = -x;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length-1;
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        String s = String.copyValueOf(chars);
        BigDecimal b = new BigDecimal(s);
        if (b.compareTo(new BigDecimal(String.valueOf(Integer.MAX_VALUE))) > 0){
            return 0;
        } else {
            return flag == 1 ? -Integer.parseInt(s) : Integer.parseInt(s);

        }

    }

    public static void main(String[] args) {
        code7 code7 = new code7();
        code7.reverse(1534236469);
    }
}
