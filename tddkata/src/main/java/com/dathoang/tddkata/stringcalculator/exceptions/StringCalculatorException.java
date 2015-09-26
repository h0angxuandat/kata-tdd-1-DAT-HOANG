package com.dathoang.tddkata.stringcalculator.exceptions;

import java.util.Arrays;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCalculatorException extends RuntimeException {

    public static final String NEGATIVE_NUMBERS_ERROR = "Negative numbers are not allowed: %s";

    public StringCalculatorException(Object[] negativeNumbers) {
        super(String.format(NEGATIVE_NUMBERS_ERROR, Arrays.toString(negativeNumbers)));
    }
}
