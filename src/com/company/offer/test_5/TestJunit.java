package com.company.offer.test_5;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TestJunit {
    private String str;
    private String result;

    public TestJunit(String str, String result) {
        this.str = str;
        this.result = result;
    }

    @Parameterized.Parameters(name = "{index}:replace({0})={1}")
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {"We are happy.","We%20are%20happy."},
                {"Wearehappy.","Wearehappy."},
                {"",""},
                {" We","%20We"},
                {"We ","We%20"},
        });
    }

    @Test
    public void testReplace(){
        assertEquals(result,Main.replace(str));
    }
}
