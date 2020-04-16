package com.company;

import com.company.offer.List.ListNode;

import java.util.*;


public class Mian {
    static String str="0123456789";
    static String str1="0123456789";

    public static String revertString(String str){
        if (str.length() <= 1){
            return str;
        }

        return revertString(str.substring(1)+ str.charAt(0));

    }

    public static void main(String[] args) {

        int i = 0;
        i = i++ + i;
        System.out.println("I =" +i);
//        System.out.println(revertString(str));

    }
}



