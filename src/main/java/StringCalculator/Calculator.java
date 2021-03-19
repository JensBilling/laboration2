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

            String[] splitNumbers = numbers.split(",");

            boolean negativeCheck = false;
            ArrayList<String> negativeNumbers = new ArrayList<>();
            for (String element : splitNumbers) {
                if (element.contains("-")){
                    negativeCheck = true;
                    negativeNumbers.add(element);
                }
            }

            if (negativeCheck)
                throw new RuntimeException("Negatives not allowed" + negativeNumbers);


            // Catches NumberFormatException if you try to add any symbols
            // other than numbers or delimiters, and returns 0 instead of crashing.
            try {
                int returnValue = 0;
                for (int i = 0; i < splitNumbers.length; i++) {
                    if (!splitNumbers[i].equals("")) {
                        splitNumbers[i] = splitNumbers[i].trim();
                        int tempLoopInt = Integer.parseInt(splitNumbers[i]);
                        returnValue += tempLoopInt;
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
