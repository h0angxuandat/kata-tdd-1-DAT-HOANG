package com.dathoang.tddkata.stringcalculator.helper;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dat Hoang on 9/27/2015.
 */
public abstract class CalculationHelper {

    private static final int MAX_RATE = 1000;
    private static final String REGEX_FORMATED_STRING = "\\";
    protected static final String END_OF_DELIMITER_STRING = "]\n";

    public final int calculate(String numbers) throws StringCalculatorException{
        if(null == numbers || "" == numbers){
            return 0;
        }

        String delimiter = GetDelimiter(numbers);
        numbers = GetStringOfNumbers(numbers);

        return GetSumFromArray(numbers.split(delimiter));
    }

    protected abstract String GetDelimiter(String numbers);

    protected abstract String GetStringOfNumbers(String numbers);

    protected final int GetSumFromArray(String[] numbers) throws StringCalculatorException {
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

    protected String MakeFormatedDelimiter(String delimiter) {
        return MakeFormatedDelimiter(delimiter.toCharArray());
    }

    protected String MakeFormatedDelimiter(char[] delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char delimiterChar : delimiter){
            stringBuilder.append(REGEX_FORMATED_STRING);
            stringBuilder.append(delimiterChar);
        }
        return stringBuilder.toString();
    }
}
