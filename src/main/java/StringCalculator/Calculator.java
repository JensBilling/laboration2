package StringCalculator;

import java.util.ArrayList;

public class Calculator {

    int add(String numbers) {

        if (numbers.equals("")) {
            return 0;

            // If String starts with //, algorithm for adding additional delimiters
        } else if (numbers.startsWith("//")) {
            int additionalDelimiterEndpoint = numbers.indexOf("\n");
            String additionalDelimiter = numbers.substring(2, additionalDelimiterEndpoint);


            // Splitting our additional delimiters into their own elements in newDelimiters array
            String[] newDelimiters = additionalDelimiter.split("]");


            // Removing left over brackets from delimiter declaration of our elements
            for (int i = 0; i < newDelimiters.length; i++) {
                newDelimiters[i] = newDelimiters[i].replace("[", "");
            }

            // Removing delimiter declaration from original string
            numbers = numbers.replace("//" + additionalDelimiter, "");
            numbers = numbers.replace(additionalDelimiter, ",");


            //replace our new delimiters with ","
            for (String newDelimiter : newDelimiters) {
                numbers = numbers.replace(newDelimiter, ",");
            }


        }


        //Replace "\n" with ","
        numbers = numbers.replace('\n', ',');


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
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed" + negativeNumbers);
        }


        // Adds all numbers together
        int returnValue = 0;
        for (Integer integerNumber : integerNumbers) {
            if (integerNumber <= 1000) {
                returnValue += integerNumber;
            }

        }

        return returnValue;
    }
}
