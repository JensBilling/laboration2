package StringCalculator;

public class Calculator {

    int add(String numbers) {

        int num1 = 0;
        int num2 = 0;

        if (numbers.equals("")) {
            return 0;

        } else if (!numbers.contains(",")) {

            // Catches NumberFormatException if you try to
            // add any symbols other than numbers, and returns 0 instead of crashing.
            try {
                return Integer.parseInt(numbers);
            } catch (NumberFormatException e) {
                return 0;
            }

        } else if (numbers.contains(",")) {

            String[] splitNumbers = numbers.split(",");

            // Catches NumberFormatException if you try to
            // add any symbols other than numbers, and returns 0 instead of crashing.
            try {
                num1 = Integer.parseInt(splitNumbers[0]);
                num2 = Integer.parseInt(splitNumbers[1]);
            } catch (NumberFormatException e) {
                return 0;
            }

        }

        return num1 + num2;
    }
}