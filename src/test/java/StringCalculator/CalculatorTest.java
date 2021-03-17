package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addTestMethod(){
        Calculator calculator = new Calculator();

        var sum = calculator.add("3,2");

        assertEquals(5, sum);

    }

}