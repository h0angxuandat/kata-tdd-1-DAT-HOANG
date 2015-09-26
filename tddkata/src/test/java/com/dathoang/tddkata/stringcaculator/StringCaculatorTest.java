package com.dathoang.tddkata.stringcaculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Dat Hoang on 9/26/2015.
 */

public class StringCaculatorTest {
    @Test
    public void TestAddWithNoAnyNumber(){
        Assert.assertEquals(0, StringCaculator.Add(""));
    }

    @Test
    public void TestAddWithOneNumber(){
        Assert.assertEquals(1, StringCaculator.Add("1"));
        Assert.assertEquals(7, StringCaculator.Add("7"));
    }

    @Test
    public void TestAddWithTwoNumbers(){
        Assert.assertEquals(4, StringCaculator.Add("3,1"));
        Assert.assertEquals(16, StringCaculator.Add("5,11"));
    }

    @Test
    public void TestAddWithUnknowamountOfNumbers(){
        Assert.assertEquals(78, StringCaculator.Add("5,11,3,4,55"));
        Assert.assertEquals(45, StringCaculator.Add("1,2,3,4,5,6,7,8,9,0"));
        Assert.assertEquals(123, StringCaculator.Add("1,2,3,4,5,6,7,8,9,0,5,11,3,4,55"));
    }
}
