package com.company.offer.test_29;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题28：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba
 */
public class Test29 {
    static List<String> res = new LinkedList<>();
    static char[] c;
    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    public static void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue; // 重复，因此剪枝
            }
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    public static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    public static void main(String[] args) {
        permutation("abc");
    }

}
