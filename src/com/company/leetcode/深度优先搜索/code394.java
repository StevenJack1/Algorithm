package com.company.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class code394 {
    public String decodeString(String s) {
        if (s.length() == 0){
            return "";
        }
        int num = 0;
        Stack<Integer> stack_num = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()){
            if (c <= '9' && c >= '0') num = num * 10 + Integer.parseInt(c + "");
            else if (c == '[') {
                stack_num.add(num);
                stack_res.add(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']'){
                StringBuilder temp = new StringBuilder();
                int index = stack_num.pop();
                for (int i = 0; i < index; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + temp);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
