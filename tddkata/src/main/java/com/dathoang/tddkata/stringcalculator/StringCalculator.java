package com.dathoang.tddkata.stringcalculator;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCalculator {

    private static final String REGEX = "[,\n]";
    public static final int MAX_RATE = 1000;

    public static int Add(String numbers) throws StringCalculatorException {
        if(null == numbers || "" == numbers){
            return 0;
        }

        String delimiter = REGEX;

        if(HasDefinedDelimiter(numbers)){
            delimiter = GetDefiniedDelimeter(numbers);
            numbers = GetStringOfNumbers(numbers);
        }

        return GetSumFromArray(numbers.split(delimiter));
    }

    private static String GetStringOfNumbers(String numbers) {
        return numbers.substring(4, numbers.length());
    }

    private static String GetDefiniedDelimeter(String numbers) {
        return "\\" + numbers.substring(2, 3);
    }

    private static boolean HasDefinedDelimiter(String numbers) {
        return numbers.startsWith("//");
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
