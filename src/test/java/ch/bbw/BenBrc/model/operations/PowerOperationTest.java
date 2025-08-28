package ch.bbw.BenBrc.model.operations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the PowerOperation class.
 */
public class PowerOperationTest {
    
    private PowerOperation operation;
    
    @Before
    public void setUp() {
        operation = new PowerOperation();
    }
    
    @Test
    public void testGetSymbol() {
        assertEquals("^", operation.getSymbol());
    }
    
    @Test
    public void testGetName() {
        assertEquals("Power", operation.getName());
    }
    
    @Test
    public void testPerform() {
        assertEquals(8.0, operation.perform(2.0, 3.0), 0.0001);
        assertEquals(1.0, operation.perform(5.0, 0.0), 0.0001);
        assertEquals(0.25, operation.perform(2.0, -1.0), 0.0001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testPerformWithInsufficientOperands() {
        operation.perform(2.0);
    }
}