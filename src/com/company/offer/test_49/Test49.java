package com.company.offer.test_49;


/**
 * （面试题49）把字符串转换成整数
 */



public class Test49 {

    public static int strToInt(String str) {
        char[] array = str.trim().toCharArray();
        if (array.length == 0){
            return 0;
        }
        long result = 0;
        int i = 1;
        int miusSign = 1;
        if (array[0] == '-') miusSign = -1;
        else if (array[0] != '+') i = 0;

        for (int j = i ; j < array.length;j++){
            if (array[j] < '0' || array[j] > '9') break;
            result = result * 10 + (array[j] - '0');
            if (result > Integer.MAX_VALUE){
                return miusSign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return miusSign * (int) result;
    }

    public static void main(String[] args) {
        strToInt("");
    }

}
