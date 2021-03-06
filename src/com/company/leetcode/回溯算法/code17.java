package com.company.leetcode.回溯算法;

import javax.management.MBeanParameterInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class code17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        backTrack(res,map,digits,0,new StringBuilder());
        return res;
    }

    public void backTrack(List<String> res,Map<Integer,String> map,String digits,int index,StringBuilder temp){
        if (index == digits.length()) {
            res.add(temp.toString());
        } else {
            char c = digits.charAt(index);
            String s = map.get(c - '0');
            int length = s.length();
            for (int i = 0; i < length; i++) {
                temp.append(s.charAt(i));
                backTrack(res,map,digits,index+1,temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
