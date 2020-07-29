package com.company.leetcode.字符串;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class code49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null){
            return new LinkedList<>();
        }
        Map<String,List<String>> map = new HashMap<>();

        int[] count = new int[26];
        for (String s : strs){
            Arrays.fill(count,0);
            for (char c : s.toCharArray()){
                count[c - 'a'] += 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String key = stringBuilder.toString();
            if (!map.containsKey(key)) map.put(key,new LinkedList<>());
            map.get(key).add(s);
        }
        return new LinkedList<>(map.values());
    }
}
