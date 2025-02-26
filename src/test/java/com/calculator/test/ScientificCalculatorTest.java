package com.calculator.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.calculator.ScientificCalculator;

public class ScientificCalculatorTest {

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, ScientificCalculator.squareRoot(16), 0.0);
        assertEquals(5.0, ScientificCalculator.squareRoot(25), 0.0);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.factorial(5));
        assertEquals(1, ScientificCalculator.factorial(0));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, ScientificCalculator.naturalLog(1), 0.0001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2, 3), 0.0);
        assertEquals(27.0, ScientificCalculator.power(3, 3), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        ScientificCalculator.factorial(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaturalLogNegativeNumber() {
        ScientificCalculator.naturalLog(-1);
    }
}
