package StringCalculator;

public class Calculator {

    int add(String numbers) {

        if (numbers.equals("")) {
            return 0;
        } else {
            numbers = numbers.replace('\n', ',');

            String[] splitNumbers = numbers.split(",");


            // Catches NumberFormatException if you try to add any symbols
            // other than numbers, and returns 0 instead of crashing.
            try {
                int returnValue = 0;
                for (int i = 0; i < splitNumbers.length; i++) {
                    splitNumbers[i] = splitNumbers[i].trim();
                    int tempLoopInt = Integer.parseInt(splitNumbers[i]);
                    returnValue += tempLoopInt;
                }

                return returnValue;
            } catch (NumberFormatException e) {
                System.out.println("Enter only numbers separated by commas(,)");
                return 0;
            }
        }
    }

}
