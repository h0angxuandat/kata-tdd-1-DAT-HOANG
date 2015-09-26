package com.dathoang.tddkata.stringcalculator.helper;

/**
 * Created by Dat Hoang on 9/27/2015.
 */
public class ComplexDefinedDelimiterHelper extends CalculationHelper {

    private static final int BEGIN_COMPLEX_DELIMITER_INDEX = 3;

    @Override
    protected String GetDelimiter(String numbers) {
        char[] delimiter =  numbers.substring(BEGIN_COMPLEX_DELIMITER_INDEX, numbers.indexOf(END_OF_DELIMITER_STRING)).toCharArray();
        return MakeFormatedDelimiter(delimiter);
    }

    @Override
    protected String GetStringOfNumbers(String numbers) {
        return numbers.split(END_OF_DELIMITER_STRING)[1];
    }
}
