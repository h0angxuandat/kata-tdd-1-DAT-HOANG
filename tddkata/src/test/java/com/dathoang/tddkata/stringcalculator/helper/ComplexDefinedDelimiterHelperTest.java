package com.dathoang.tddkata.stringcalculator.helper;

import org.junit.Assert;
import org.junit.Test;

public class ComplexDefinedDelimiterHelperTest {
    @Test
    public void TestComplexDefinedDelimiterHelperTest(){
        Assert.assertEquals(16, new ComplexDefinedDelimiterHelper().calculate("//[$$$]\n5$$$11"));
        Assert.assertEquals(78, new ComplexDefinedDelimiterHelper().calculate("//[**]\n5**11**3**4**55"));
        Assert.assertEquals(123, new ComplexDefinedDelimiterHelper().calculate("//[$%&*]\n1$%&*2$%&*3$%&*4$%&*5$%&*6$%&*7$%&*8$%&*9$%&*0$%&*5$%&*11$%&*3$%&*4$%&*55"));
    }
}