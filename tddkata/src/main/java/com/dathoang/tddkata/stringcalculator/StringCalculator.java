package com.dathoang.tddkata.stringcalculator;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCalculator {

    private static final String REGEX = "[,\n]";
    private static final int MAX_RATE = 1000;
    private static final String SIMPLE_DELIMETER_PREFIX = "//";
    private static final String COMPLEX_DELIMETER_PREFIX = "//[";
    private static final int BEGIN_SIMPLE_DELIMETER_INDEX = 2;
    private static final int BEGIN_COMPLEX_DELIMETER_INDEX = 3;
    private static final int BEGIN_SIMPLE_NUMBERS_INDEX = 4;
    private static final int END_SIMPLE_DELIMETER_INDEX = 3;
    private static final String END_OF_DELIMETER_STRING = "]\n";
    private static final String REGEX_FORMATED_STRING = "\\";

    public static int Add(String numbers) throws StringCalculatorException {
        if(null == numbers || "" == numbers){
            return 0;
        }

        String delimiter = REGEX;

        if(HasSimpleDefinedDelimiter(numbers)){
            delimiter = GetDefiniedDelimeter(numbers);
            numbers = GetStringOfNumbers(numbers);
        }

        if(HasComplexDefinedDelimiter(numbers)){
            delimiter = GetComplexDefiniedDelimeter(numbers);
            numbers = GetComplexStringOfNumbers(numbers);
        }

        return GetSumFromArray(numbers.split(delimiter));
    }

    private static String GetComplexStringOfNumbers(String numbers) {
        return numbers.split(END_OF_DELIMETER_STRING)[1];
    }

    private static String GetComplexDefiniedDelimeter(String numbers) {
        char[] delimiter =  numbers.substring(BEGIN_COMPLEX_DELIMETER_INDEX, numbers.indexOf(END_OF_DELIMETER_STRING)).toCharArray();
        return MakeFormatedDelimiter(delimiter);
    }

    private static String MakeFormatedDelimiter(char[] delimiter) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char delimiterChar : delimiter){
            stringBuffer.append(REGEX_FORMATED_STRING);
            stringBuffer.append(delimiterChar);
        }
        return stringBuffer.toString();
    }

    private static boolean HasComplexDefinedDelimiter(String numbers) {
        return numbers.startsWith(COMPLEX_DELIMETER_PREFIX);
    }

    private static String GetStringOfNumbers(String numbers) {
        return numbers.substring(BEGIN_SIMPLE_NUMBERS_INDEX, numbers.length());
    }

    private static String GetDefiniedDelimeter(String numbers) {
        return REGEX_FORMATED_STRING + numbers.substring(BEGIN_SIMPLE_DELIMETER_INDEX, END_SIMPLE_DELIMETER_INDEX);
    }

    private static boolean HasSimpleDefinedDelimiter(String numbers) {
        return numbers.startsWith(SIMPLE_DELIMETER_PREFIX) && !numbers.startsWith(COMPLEX_DELIMETER_PREFIX);
    }

    private static int GetSumFromArray(String[] numbers) {
        int sum = 0;
        boolean hasNegative = false;
        List<Integer> negativeNumbers = new ArrayList<Integer>();

        for(String number : numbers) {
            Integer numAsInt = new Integer(number);

            if(0 > numAsInt) {
                hasNegative = true;
                negativeNumbers.add(numAsInt);
            } else if (!hasNegative && MAX_RATE >= numAsInt){
                sum += new Integer(number);
            }
        }

        if(hasNegative) {
            throw new StringCalculatorException(negativeNumbers.toArray());
        }

        return sum;
    }
}
