package com.dathoang.tddkata.stringcalculator.helper;

/**
 * Created by Dat Hoang on 9/27/2015.
 */
public class SimpleCalculationHelper extends CalculationHelper {
    private static final String REGEX = "[,\n]";

    @Override
    protected String GetDelimiter(String numbers) {
        return REGEX;
    }

    @Override
    protected String GetStringOfNumbers(String numbers) {
        return numbers;
    }
}
