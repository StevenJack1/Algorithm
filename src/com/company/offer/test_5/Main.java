package com.company.offer.test_5;


/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入“We are happy.”，则输出“We%20are%20happy.”。
 *
 * 字符串
 */




public class Main {

    public static String replace(String str){
        int len = str.length();
        char[] array = new char[len*3];
        int size = 0;
        for (int i = 0;i < len; i++){
            char c = str.charAt(i);
            if (c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else{
                array[size++] = c;
            }
        }
        return new String(array,0,size);
    }


    public static void main(String[] args) {
        String str = " ";

        System.out.println(replace(str));


    }



}
