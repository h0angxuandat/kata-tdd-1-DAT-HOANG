package com.dathoang.tddkata.stringcaculator;

import com.dathoang.tddkata.stringcaculator.exceptions.StringCaculatorException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Dat Hoang on 9/26/2015.
 */

public class StringCaculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void TestAddWithNoAnyNumber() throws StringCaculatorException {
        Assert.assertEquals(0, StringCaculator.Add(""));
    }

    @Test
    public void TestAddWithOneNumber() throws StringCaculatorException {
        Assert.assertEquals(1, StringCaculator.Add("1"));
        Assert.assertEquals(7, StringCaculator.Add("7"));
    }

    @Test
    public void TestAddWithTwoNumbers() throws StringCaculatorException {
        Assert.assertEquals(4, StringCaculator.Add("3,1"));
        Assert.assertEquals(16, StringCaculator.Add("5,11"));
    }

    @Test
    public void TestAddWithUnknowamountOfNumbers() throws StringCaculatorException {
        Assert.assertEquals(78, StringCaculator.Add("5,11,3,4,55"));
        Assert.assertEquals(45, StringCaculator.Add("1,2,3,4,5,6,7,8,9,0"));
        Assert.assertEquals(123, StringCaculator.Add("1,2,3,4,5,6,7,8,9,0,5,11,3,4,55"));
    }

    @Test
    public void TestAddWithNewlineBetweenNumbers() throws StringCaculatorException {
        Assert.assertEquals(45, StringCaculator.Add("1,2,3\n4,5,6,7\n8,9\n0"));
    }

    @Test
    public void TestAddWithDifferentDefinedDelimiters() throws StringCaculatorException {
        Assert.assertEquals(16, StringCaculator.Add("//$\n5$11"));
        Assert.assertEquals(78, StringCaculator.Add("//;\n5;11;3;4;55"));
        Assert.assertEquals(123, StringCaculator.Add("//*\n1*2*3*4*5*6*7*8*9*0*5*11*3*4*55"));
    }

    @Test
    public void TestAddWithNegativeNumbers() {
        expectedException.expect(StringCaculatorException.class);
        expectedException.expectMessage("Negative numbers are not allowed: [-7, -9]");
        StringCaculator.Add("1,-7,8,-9,11");
    }
}
