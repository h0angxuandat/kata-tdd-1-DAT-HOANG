package com.dathoang.tddkata.stringcalculator.helper;

import org.junit.Assert;
import org.junit.Test;

public class MultipleDelimitersHelperTest {
    @Test
    public void TestMultipleDelimitersHelperTest(){
        Assert.assertEquals(78, new MultipleDelimitersHelper().calculate("//[;;;;][**]\n5;;;;11**3**4;;;;55"));
        Assert.assertEquals(123, new MultipleDelimitersHelper().calculate("//[***][$$][,][.]\n1***2$$3***4***5,6***7***8$$9***0.5$$11***3.4,55"));
    }
}