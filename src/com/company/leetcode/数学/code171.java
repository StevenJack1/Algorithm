package com.company.leetcode.数学;

/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 */
public class code171 {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        if (len == 1){
            res = s.charAt(0) - 64;
        } else {
            for (int i = 0; i < len; i++) {
                int temp = s.charAt(i) - 64;
                res += Math.pow(26,len-1-i) * temp;
            }
//            res += 26;
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        code171 code171 = new code171();
        String s = "AAA";
        code171.titleToNumber(s);
    }
}
