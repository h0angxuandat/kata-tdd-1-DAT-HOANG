package com.dathoang.tddkata.stringcalculator.helper;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;
import org.junit.Assert;
import org.junit.Test;

public class SimpleDefinedDelimiterHelperTest {
    @Test
    public void TestSimpleDefinedDelimiterHelperTest() throws StringCalculatorException {
        Assert.assertEquals(16, new SimpleDefinedDelimiterHelper().calculate("//$\n5$11"));
        Assert.assertEquals(78, new SimpleDefinedDelimiterHelper().calculate("//;\n5;11;3;4;55"));
        Assert.assertEquals(123, new SimpleDefinedDelimiterHelper().calculate("//*\n1*2*3*4*5*6*7*8*9*0*5*11*3*4*55"));
    }
}