package com.dathoang.tddkata.stringcaculator.exceptions;

import java.util.Arrays;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCaculatorException extends RuntimeException {

    public static final String NEGATIVE_NUMBERS_ERROR = "Negative numbers are not allowed: %s";

    public StringCaculatorException(Object[] negativeNumbers) {
        super(String.format(NEGATIVE_NUMBERS_ERROR, Arrays.toString(negativeNumbers)));
    }
}
