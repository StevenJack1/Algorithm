package com.company.offer.test_41;


/**
 * 面试题40：数组中只出现一次的数字
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是 O（n），空间复杂度是O（1）。
 * 例如输入数组{2,4,3,6,3,2,5,5}，因为只有4、6这两个数字只出现一次，其他数字都出现了两次，
 * 所以输出4和6。
 */
public class Test41 {


    public static int[] singleNumbers(int[] nums) {
        int sum=0;
        //将数组所有元素进行异或，最后的结果一定是那两个单一数字的异或结果。看上图示例
        //用示例[4,4,6,1]最后的抑或结果就是 6和1异或的结果 7
        for (int i = 0; i <nums.length ; i++) {
            sum^=nums[i];
        }
        int first = 1;
        //通过与运算找到result第一个不为0的首位，7=>0111，也就是第一位
        while((sum&first)==0){
            first=first<<1;
        }
        //first为1，所以我们可以根据数组元素的二进制低位第一位是否为1，将数组分为2类，
        // 示例数组可以分为     低位第一位为0：[4,4,6]     低位第一位为1：[1]
        //此时再将两个数组两两异或就可以得到最终结果。
        int result[]=new int[2];
        for(int i=0;i<nums.length;i++){
            //将数组分类。
            if((nums[i]&first)==0){
                result[0]^=nums[i];
            }
            else{
                result[1]^=nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        singleNumbers(arr);
    }

}
