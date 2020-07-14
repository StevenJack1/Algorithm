package com.company.leetcode.双指针;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class code125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

        int left = 0;
        int right = chars.length-1;
        while (left < right){
            if (chars[left] == chars[right]){
                left++;
                right--;
            } else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        code125 code125 = new code125();
        String s = "A man, a plan, a canal: Panama";
        code125.isPalindrome(s);
    }
}
