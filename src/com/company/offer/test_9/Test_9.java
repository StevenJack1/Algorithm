package com.company.offer.test_9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class Test_9 {
    private int[] array;
    private int result;

    public Test_9(int[] array, int result) {
        this.array = array;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data(){
        int[] input1 = {4,5,6,7,8,9,1,2,3};
        int[] input2 = {1,1,1,1,1,1,1,1,1};
        int[] input3 = {1,2,3,1};
        int[] input4 = {1};
        int[] input5 = {};
        return Arrays.asList(new Object[][] {
                {input1,1},
                {input2,1},
                {input3,1},
                {input4,1},
                {input5,-1},
        });
    }

    @Test
    public void test_9(){
        assertEquals(result,Main.arrayMin(array));
    }
}
