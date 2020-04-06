package com.company.basicStructure;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] array,int item){
        int low = 0;
        int high = array.length -1;
        int middle = 0;
        while (low <= high){
            middle = (low + high)/2 ;
            if (array[middle] > item){
                low = middle + 1;
            }else if (array[middle] < item){
                high = middle - 1;
            } else {
                break;
            }

        }
        return array[middle];
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
    }
}
