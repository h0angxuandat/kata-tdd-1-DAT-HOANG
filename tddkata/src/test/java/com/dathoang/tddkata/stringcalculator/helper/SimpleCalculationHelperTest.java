package com.dathoang.tddkata.stringcalculator.helper;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;
import org.junit.Assert;
import org.junit.Test;

public class SimpleCalculationHelperTest {
    @Test
    public void TestSimpleCalculationHelperTest() throws StringCalculatorException {
        Assert.assertEquals(0, new SimpleCalculationHelper().calculate(""));
        Assert.assertEquals(4, new SimpleCalculationHelper().calculate("3,1"));
        Assert.assertEquals(16, new SimpleCalculationHelper().calculate("5,11"));
    }
}