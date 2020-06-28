package com.company.basicStructure.sort;

/**
 * 归并排序
 * 思路：
 * 分解：将序列每次折半拆分。
 * 合并：将拆分开的两个序列排序后合并。
 */
public class Merge {

    public static void merge(int[] a,int left,int middle,int right){
        int [] temp = new int[a.length];
        int i = left;
        int j = middle+1;
        int t = left;

        while (i<=middle && j<=right){
            if(a[i]<=a[j]){
                temp[t++] = a[i++];
            }else {
                temp[t++] = a[j++];
            }
        }
        while(i<=middle){
            temp[t++] = a[i++];
        }
        while(j<=right){
            temp[t++] = a[j++];
        }

        //复制回原数组
        for (int k = left; k <= right; k++) {
            a[k] = temp[k];
        }
    }

    public static void sort(int[] a,int left,int right){
        if (left < right) {
            int middle = (left+right)/2;
            sort(a,left,middle);
            sort(a,middle+1,right);
            merge(a,left,middle,right);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,12,34,1,7,4,112};
        sort(a,0,a.length-1);
        for (int c:a){
            System.out.println(c);
        }
    }
}
