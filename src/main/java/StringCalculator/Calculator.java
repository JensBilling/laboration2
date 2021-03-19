package StringCalculator;

import java.util.ArrayList;

public class Calculator {

    int add(String numbers) {

        if (numbers.equals("")) {
            return 0;
        } else {
            numbers = numbers.replace('\n', ',');
            String additionalDelimiter;
            if (numbers.startsWith("//")) {
                additionalDelimiter = numbers.substring(2, 3);
                numbers = numbers.replace("//" + additionalDelimiter, "");
                numbers = numbers.replace(additionalDelimiter, ",");
            }


            // Splits numbers of String into individual array elements
            String[] splitNumbers = numbers.split(",");


            // Convert String elements of splitNumbers into Integer elements in an arraylist and removes empty elements
            ArrayList<Integer> integerNumbers = new ArrayList<>();
            for (String element : splitNumbers) {
                if (!element.equals("")) {
                    element = element.trim();
                    integerNumbers.add(Integer.parseInt(element));
                }
            }


            // Checks for negative numbers and throws exception if found
            ArrayList<Integer> negativeNumbers = new ArrayList<>();
            for (Integer element : integerNumbers) {
                if (element < 0) {
                    negativeNumbers.add(element);
                }
            }
            if (numbers.contains("-"))
                throw new RuntimeException("Negatives not allowed" + negativeNumbers);


            // Catches NumberFormatException if you try to add any symbols
            // other than numbers or delimiters, and returns 0 instead of crashing.
            try {
                int returnValue = 0;
                for (Integer integerNumber : integerNumbers) {
                    if (integerNumber <= 1000) {
                        returnValue += integerNumber;
                    }

                }

                return returnValue;
            } catch (NumberFormatException e) {
                System.out.println("ERROR. Invalid input, returning 0");
                return 0;
            }
        }
    }

}
