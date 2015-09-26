package com.dathoang.tddkata.stringcalculator;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;
import com.googlecode.instinct.marker.annotate.Specification;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Dat Hoang on 9/26/2015.
 */

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void TestAddWithNoAnyNumber() throws StringCalculatorException {
        Assert.assertEquals(0, StringCalculator.Add(""));
    }

    @Test
    public void TestAddWithOneNumber() throws StringCalculatorException {
        Assert.assertEquals(1, StringCalculator.Add("1"));
        Assert.assertEquals(7, StringCalculator.Add("7"));
    }

    @Test
    public void TestAddWithTwoNumbers() throws StringCalculatorException {
        Assert.assertEquals(4, StringCalculator.Add("3,1"));
        Assert.assertEquals(16, StringCalculator.Add("5,11"));
    }

    @Test
    public void TestAddWithUnknowamountOfNumbers() throws StringCalculatorException {
        Assert.assertEquals(78, StringCalculator.Add("5,11,3,4,55"));
        Assert.assertEquals(45, StringCalculator.Add("1,2,3,4,5,6,7,8,9,0"));
        Assert.assertEquals(123, StringCalculator.Add("1,2,3,4,5,6,7,8,9,0,5,11,3,4,55"));
    }

    @Test
    public void TestAddWithNewlineBetweenNumbers() throws StringCalculatorException {
        Assert.assertEquals(45, StringCalculator.Add("1,2,3\n4,5,6,7\n8,9\n0"));
    }

    @Test
    public void TestAddWithDifferentDefinedDelimiters() throws StringCalculatorException {
        Assert.assertEquals(16, StringCalculator.Add("//$\n5$11"));
        Assert.assertEquals(78, StringCalculator.Add("//;\n5;11;3;4;55"));
        Assert.assertEquals(123, StringCalculator.Add("//*\n1*2*3*4*5*6*7*8*9*0*5*11*3*4*55"));
    }

    @Test
    @Specification(expectedException = StringCalculatorException.class)
    public void TestAddWithNegativeNumbers() throws StringCalculatorException {
        expectedException.expect(StringCalculatorException.class);
        expectedException.expectMessage("Negative numbers are not allowed: [-7, -9]");
        StringCalculator.Add("1,-7,8,-9,11");
    }

    @Test
    public void TestAddWithBiggerOneThousandNumbers(){
        Assert.assertEquals(5, StringCalculator.Add("3,7777,1,2222,1"));
        Assert.assertEquals(16, StringCalculator.Add("//*\n5*1007*11*9999"));
    }
}
