package com.company.offer.test_43;


import java.util.Stack;

/**
 * 面试题42：翻转单词顺序 VS左旋转字符串
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student."，
 * 则输出"student.a am I"
 *
 * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转2位得到的结果"cdefgab"。
 */
public class Test43 {

    public static String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length-1;i >= 0;i--){
            if (s1[i].equals("")) {
                continue;
            } else {
                stringBuilder.append(s1[i] + " ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    public static void main(String[] args) {
        String s = "a good   example";
        reverseWords(s);
    }
}
