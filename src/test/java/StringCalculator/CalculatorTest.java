package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void multiNumberAddTest() {
        Calculator calculator = new Calculator();

        var sum = calculator.add("1\n2,3");
        assertEquals(6, sum);
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

    @Test
    void additionalDelimiterAddTest() {
        Calculator calculator = new Calculator();

        var sum = calculator.add("//*\n1,2\n3*4");


        assertEquals(10, sum);
    }

    @Test
    void additionalMultiDelimiterAddTest() {
        Calculator calculator = new Calculator();

        var sum = calculator.add("//[*][;][DELIMITER][\n1,2\n3*4;5DELIMITER6");

        assertEquals(21, sum);
    }
}