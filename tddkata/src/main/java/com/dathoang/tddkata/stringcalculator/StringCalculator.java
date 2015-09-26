package com.dathoang.tddkata.stringcalculator;

import com.dathoang.tddkata.stringcalculator.exceptions.StringCalculatorException;
import com.dathoang.tddkata.stringcalculator.helper.ComplexDefinedDelimiterHelper;
import com.dathoang.tddkata.stringcalculator.helper.MultipleDelimitersHelper;
import com.dathoang.tddkata.stringcalculator.helper.SimpleCalculationHelper;
import com.dathoang.tddkata.stringcalculator.helper.SimpleDefinedDelimiterHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dat Hoang on 9/26/2015.
 */
public class StringCalculator {

    private static final String SIMPLE_DELIMITER_PREFIX = "//";
    private static final String COMPLEX_DELIMITER_PREFIX = "//[";
    private static final String DELIMITERS_SEPARATOR_STRING = "][";

    public static int Add(String numbers) throws StringCalculatorException {
        if(null == numbers || "" == numbers){
            return 0;
        }

        if(HasSimpleDefinedDelimiter(numbers)){
            return new SimpleDefinedDelimiterHelper().calculate(numbers);
        }

        if(HasComplexDefinedDelimiter(numbers)){
            return new ComplexDefinedDelimiterHelper().calculate(numbers);
        }

        if(HasMultipleDefinedDelimiter(numbers)){
            return new MultipleDelimitersHelper().calculate(numbers);
        }

        return new SimpleCalculationHelper().calculate(numbers);
    }

    private static boolean HasMultipleDefinedDelimiter(String numbers) {
        return numbers.startsWith(COMPLEX_DELIMITER_PREFIX) && numbers.contains(DELIMITERS_SEPARATOR_STRING);
    }

    private static boolean HasComplexDefinedDelimiter(String numbers) {
        return numbers.startsWith(COMPLEX_DELIMITER_PREFIX) && !numbers.contains("][");
    }

    private static boolean HasSimpleDefinedDelimiter(String numbers) {
        return numbers.startsWith(SIMPLE_DELIMITER_PREFIX) && !numbers.startsWith(COMPLEX_DELIMITER_PREFIX);
    }
}
