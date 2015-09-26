package com.dathoang.tddkata.stringcalculator.helper;

/**
 * Created by Dat Hoang on 9/27/2015.
 */
public class MultipleDelimitersHelper extends CalculationHelper {

    private static final String REGEX_DELIMITERS_SEPARATOR = "\\]\\[";
    private static final String DELIMITER_PARTS = "\\/\\/\\[|\\]\\[|\\]\\n";
    private static final String REGEX_OR = "|";

    @Override
    protected String GetDelimiter(String numbers) {
        int amountOfDelimiters = GetAmountOfDelimiters(numbers);
        String[] delimitersArray = GetDelimitersArray(numbers, amountOfDelimiters);
        return BuildMultipleDelimiter(delimitersArray);
    }

    @Override
    protected String GetStringOfNumbers(String numbers) {
        return numbers.split(END_OF_DELIMITER_STRING)[1];
    }

    private int GetAmountOfDelimiters(String numbers) {
        return numbers.split(REGEX_DELIMITERS_SEPARATOR).length;
    }

    private String[] GetDelimitersArray(String numbers, int amountOfDelimiters) {
        String[] delimitersArray = new String[amountOfDelimiters];
        String[] splitResault = numbers.split(DELIMITER_PARTS);

        for(int i = 1; i <= amountOfDelimiters; i++){
            delimitersArray[i - 1] = splitResault[i];
        }
        return delimitersArray;
    }

    private String BuildMultipleDelimiter(String[] delimitersArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < delimitersArray.length; i++){
            stringBuilder.append(MakeFormatedDelimiter(delimitersArray[i]));
            if(delimitersArray.length - 1 > i){
                stringBuilder.append(REGEX_OR);
            }
        }
        return stringBuilder.toString();
    }
}
