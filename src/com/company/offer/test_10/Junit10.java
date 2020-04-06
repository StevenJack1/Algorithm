package com.company.offer.test_10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class Junit10 {
    private int input;
    private int output;

    public Junit10(int input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{index}:cal({0})={1}")
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {1,1},
                {2,1},
                {3,2},
                {20,6765}
        });
    }

    @Test
    public void test(){
        assertEquals(output,Test10.cal(input));
    }

}
