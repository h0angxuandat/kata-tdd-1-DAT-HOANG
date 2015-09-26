package com.dathoang.tddkata.stringcaculator;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCaculator {

    public static int Add(String numbers) {
        if(null == numbers || "" == numbers){
            return 0;
        }

        String delimiter = ",";
        return GetSumFromArray(numbers.split(delimiter));
    }

    private static int GetSumFromArray(String[] numbers) {
        int sum = 0;

        for(String number : numbers) {
            sum += new Integer(number);
        }

        return sum;
    }

}
