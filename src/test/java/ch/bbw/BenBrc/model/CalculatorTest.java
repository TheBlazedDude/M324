package ch.bbw.BenBrc.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Calculator class.
 */
public class CalculatorTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.0001);
        assertEquals(-1.0, calculator.add(2.0, -3.0), 0.0001);
        assertEquals(0.0, calculator.add(0.0, 0.0), 0.0001);
    }
    
    @Test
    public void testSubtract() {
        assertEquals(-1.0, calculator.subtract(2.0, 3.0), 0.0001);
        assertEquals(5.0, calculator.subtract(2.0, -3.0), 0.0001);
        assertEquals(0.0, calculator.subtract(0.0, 0.0), 0.0001);
    }
    
    @Test
    public void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.0001);
        assertEquals(-6.0, calculator.multiply(2.0, -3.0), 0.0001);
        assertEquals(0.0, calculator.multiply(0.0, 5.0), 0.0001);
    }
    
    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.0001);
        assertEquals(-2.0, calculator.divide(6.0, -3.0), 0.0001);
        assertEquals(0.0, calculator.divide(0.0, 5.0), 0.0001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5.0, 0.0);
    }
}