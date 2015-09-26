package com.dathoang.tddkata.stringcalculator.helper;

/**
 * Created by Dat Hoang on 9/27/2015.
 */
public class SimpleDefinedDelimiterHelper extends CalculationHelper {

    private static final int BEGIN_SIMPLE_DELIMITER_INDEX = 2;
    private static final int END_SIMPLE_DELIMITER_INDEX = 3;
    private static final int BEGIN_SIMPLE_NUMBERS_INDEX = 4;

    @Override
    protected String GetDelimiter(String numbers) {
        return MakeFormatedDelimiter(numbers.substring(BEGIN_SIMPLE_DELIMITER_INDEX, END_SIMPLE_DELIMITER_INDEX));
    }

    @Override
    protected String GetStringOfNumbers(String numbers) {
        return numbers.substring(BEGIN_SIMPLE_NUMBERS_INDEX, numbers.length());
    }


}
