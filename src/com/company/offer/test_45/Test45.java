package com.company.offer.test_45;

import java.util.Arrays;

/**
 * 面试题44：扑克牌的顺子
 * 题目：从扑克牌中随机抽 5张牌，判断是不是一个顺子，即这 5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
public class Test45 {

    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i++]) return false;
        }
        return nums[4] - nums[joker] < 5;
    }

}
