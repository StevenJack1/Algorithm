package com.company.leetcode.字符串;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class code14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String res = strs[0];
        for (String cur:strs){
            int j = 0;
            for (; j < res.length() && j < cur.length() ; j++){
                if (res.charAt(j) != cur.charAt(j)){
                    break;
                }
            }
            res = res.substring(0,j);
            if (res.equals("")){
                return "";
            }
        }
        return res;
    }

}
