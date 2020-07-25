package com.company.leetcode.回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class code22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backTrack(res,n,n,new StringBuilder());
        return res;
    }

    public void backTrack(List<String> res,int left,int right,StringBuilder temp){
        if (left == 0 && right ==0){
            res.add(temp.toString());
            return;
        }

        if (left > right){
            return;
        }
        if (left > 0){
            temp.append("(");
            backTrack(res,left-1,right,temp);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (right > 0){
            temp.append(")");
            backTrack(res,left,right-1,temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
