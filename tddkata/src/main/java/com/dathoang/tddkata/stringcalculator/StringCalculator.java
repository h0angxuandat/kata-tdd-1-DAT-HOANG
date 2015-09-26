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
    public static final String REGEX_OR = "|";
    public static final String DELIMITER_PARTS = "\\/\\/\\[|\\]\\[|\\]\\n";
    public static final String REGEX_DELIMITERS_SEPARATOR = "\\]\\[";
    public static final String DELIMITERS_SEPARATOR_STRING = "][";

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

        if(HasMultipleDefinedDelimiter(numbers)){
            delimiter = GetMultipleDefiniedDelimeter(numbers);
            numbers = GetComplexStringOfNumbers(numbers);
        }

        return GetSumFromArray(numbers.split(delimiter));
    }

    private static String GetMultipleDefiniedDelimeter(String numbers) {
        int amountOfDelimeters = GetAmountOfDelimeters(numbers);
        String[] delimetersArray = GetDelimetersArray(numbers, amountOfDelimeters);
        return BuildMultipleDelimeter(delimetersArray);
    }

    private static String BuildMultipleDelimeter(String[] delimetersArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < delimetersArray.length; i++){
            stringBuilder.append(MakeFormatedDelimiter(delimetersArray[i]));
            if(delimetersArray.length - 1 > i){
                stringBuilder.append(REGEX_OR);
            }
        }
        return stringBuilder.toString();
    }

    private static String[] GetDelimetersArray(String numbers, int amountOfDelimeters) {
        String[] delimetersArray = new String[amountOfDelimeters];
        String[] splitResault = numbers.split(DELIMITER_PARTS);

        for(int i = 1; i <= amountOfDelimeters; i++){
            delimetersArray[i - 1] = splitResault[i];
        }
        return delimetersArray;
    }

    private static int GetAmountOfDelimeters(String numbers) {
        return numbers.split(REGEX_DELIMITERS_SEPARATOR).length;
    }

    private static boolean HasMultipleDefinedDelimiter(String numbers) {
        return numbers.startsWith(COMPLEX_DELIMETER_PREFIX) && numbers.contains(DELIMITERS_SEPARATOR_STRING);
    }

    private static String GetComplexStringOfNumbers(String numbers) {
        return numbers.split(END_OF_DELIMETER_STRING)[1];
    }

    private static String GetComplexDefiniedDelimeter(String numbers) {
        char[] delimiter =  numbers.substring(BEGIN_COMPLEX_DELIMETER_INDEX, numbers.indexOf(END_OF_DELIMETER_STRING)).toCharArray();
        return MakeFormatedDelimiter(delimiter);
    }

    private static String MakeFormatedDelimiter(String delimiter) {
        return MakeFormatedDelimiter(delimiter.toCharArray());
    }

    private static String MakeFormatedDelimiter(char[] delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char delimiterChar : delimiter){
            stringBuilder.append(REGEX_FORMATED_STRING);
            stringBuilder.append(delimiterChar);
        }
        return stringBuilder.toString();
    }

    private static boolean HasComplexDefinedDelimiter(String numbers) {
        return numbers.startsWith(COMPLEX_DELIMETER_PREFIX) && !numbers.contains("][");
    }

    private static String GetStringOfNumbers(String numbers) {
        return numbers.substring(BEGIN_SIMPLE_NUMBERS_INDEX, numbers.length());
    }

    private static String GetDefiniedDelimeter(String numbers) {
        return MakeFormatedDelimiter(numbers.substring(BEGIN_SIMPLE_DELIMETER_INDEX, END_SIMPLE_DELIMETER_INDEX));
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
