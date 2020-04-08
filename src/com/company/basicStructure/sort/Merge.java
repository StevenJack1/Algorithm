package com.company.basicStructure.sort;

/**
 * 归并排序
 * 思路：
 * 分解：将序列每次折半拆分。
 * 合并：将拆分开的两个序列排序后合并。
 */
public class Merge {

    public static void merge(int[] a,int left,int middle,int right,int[] temp){

        int i = left;
        int j = middle+1;
        int t = 0;
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
        System.out.println("left:"+left+ "middle:"+middle+ "right:"+right);

        t = 0;

        while(left <= right){
            a[left++] = temp[t++];
        }

    }



    public static void sort(int[] a,int left,int right,int[] temp){
        if (a == null){
            return;
        }
        if (right <0){
            return;
        }
        if (left == right){
            return;
        } else {
            int middle = (left+right)/2;
            sort(a,left,middle,temp);
            sort(a,middle+1,right,temp);
            merge(a,left,middle,right,temp);
        }

    }

    public static void main(String[] args) {
        int[] a = {2,12,34,1,7,4,112};
        int len = a.length;
        int[] temp = new int[len];
        sort(a,0,len-1,temp);
        for (int c:a){
            System.out.println(c);
        }
    }
}
