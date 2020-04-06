package com.company.offer.test_3;

public class Main {


    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int row = 0;
        int col = array[0].length-1;

        int number = -1;
        boolean flag = true;

        while (flag){
            int current = array[row][col];

            if (current == number){
                break;
            } else if (current > number){
                col = col - 1;
            } else if (current < number){
                row = row + 1;
            }

            if (row == array.length || col < 0){
                flag = false;
                System.out.println("未找到值,"+"row:"+row+"col:"+col);
                break;
            }


        }
        if (flag == true){
            System.out.println("行："+ row);
            System.out.println("列："+ col);
            System.out.println("当前值:"+array[row][col]);
        }
    }
}
