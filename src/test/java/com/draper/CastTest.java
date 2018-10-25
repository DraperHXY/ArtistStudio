package com.draper;


import org.junit.Test;

public class CastTest {

    @Test
    public void testIntegerCastLong(){
        Integer integer = 46;
        Long l = Long.valueOf(integer);
        System.out.println(l);

    }

}
