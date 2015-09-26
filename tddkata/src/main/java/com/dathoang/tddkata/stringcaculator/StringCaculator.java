package com.dathoang.tddkata.stringcaculator;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCaculator {
    
    private static final String REGEX = "[,\n]";

    public static int Add(String numbers) {
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

        for(String number : numbers) {
            sum += new Integer(number);
        }

        return sum;
    }

}
