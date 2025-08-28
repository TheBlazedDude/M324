package ch.bbw.BenBrc.model.operations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the SquareRootOperation class.
 */
public class SquareRootOperationTest {
    
    private SquareRootOperation operation;
    
    @Before
    public void setUp() {
        operation = new SquareRootOperation();
    }
    
    @Test
    public void testGetSymbol() {
        assertEquals("sqrt", operation.getSymbol());
    }
    
    @Test
    public void testGetName() {
        assertEquals("Square Root", operation.getName());
    }
    
    @Test
    public void testPerform() {
        assertEquals(4.0, operation.perform(16.0), 0.0001);
        assertEquals(0.0, operation.perform(0.0), 0.0001);
        assertEquals(1.0, operation.perform(1.0), 0.0001);
        assertEquals(1.414213, operation.perform(2.0), 0.0001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testPerformWithNegativeNumber() {
        operation.perform(-1.0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testPerformWithInsufficientOperands() {
        operation.perform();
    }
}