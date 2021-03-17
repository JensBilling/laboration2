package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void multiNumberAddTest() {
        Calculator calculator = new Calculator();

        var sum = calculator.add("5,3,7,2,10");
        assertEquals(27, sum);
    }

    @Test
    void singleNumberAddTest() {
        Calculator calculator = new Calculator();

        int sum = calculator.add("4");
        assertEquals(4, sum);
    }

    @Test
    void emptyNumberAddTest() {
        Calculator calculator = new Calculator();

        int sum = calculator.add("");
        assertEquals(0, sum);
    }

}