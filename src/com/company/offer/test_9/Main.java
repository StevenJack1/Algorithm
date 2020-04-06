package com.company.offer.test_9;

/**
 * 面试题8：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class Main {

    public static int arrayMin(int[] array){
        if (array.length == 0){
            return -1;
        }
        int low = 0;
        int high = array.length -1;
        int middle = 0;
        while (low < high){
            if (high - low == 1){
                middle = high;
                break;
            }

            middle = (low + high)/2 ;
            if (array[middle] >= array[low]){
                low = middle;
            }
            if (array[middle] <= array[high]){
                high = middle;
            }

        }
        return array[middle];
    }
}
