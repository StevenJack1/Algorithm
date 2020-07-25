package com.company.leetcode.回溯算法;



import java.util.LinkedList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class code784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        backTrack(S,res,new StringBuilder());
        return res;
    }

    public void backTrack(String s,List<String> res,StringBuilder temp){
        if (s.length() == temp.length()){
            res.add(temp.toString());
            return;
        } else {
            char c = s.charAt(temp.length());
            if ('0' <= c && c <= '9'){
                temp.append(c);
                backTrack(s,res,temp);
                temp.deleteCharAt(temp.length()-1);
            } else {
                temp.append(Character.toLowerCase(c));
                backTrack(s,res,temp);
                temp.deleteCharAt(temp.length()-1);

                temp.append(Character.toUpperCase(c));
                backTrack(s,res,temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
