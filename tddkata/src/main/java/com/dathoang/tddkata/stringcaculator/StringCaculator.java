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

        return GetSumFromArray(numbers.split(REGEX));
    }

    private static int GetSumFromArray(String[] numbers) {
        int sum = 0;

        for(String number : numbers) {
            sum += new Integer(number);
        }

        return sum;
    }

}
