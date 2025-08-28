package ch.bbw.BenBrc.module;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ch.bbw.BenBrc.model.OperationRegistry;

/**
 * Unit tests for the PowerModule class.
 */
public class PowerModuleTest {
    
    private PowerModule module;
    private OperationRegistry registry;
    
    @Before
    public void setUp() {
        module = new PowerModule();
        registry = OperationRegistry.getInstance();
    }
    
    @Test
    public void testGetName() {
        assertEquals("Power Module", module.getName());
    }
    
    @Test
    public void testGetDescription() {
        assertEquals("Adds the power operation (^) to the calculator.", module.getDescription());
    }
    
    @Test
    public void testGetVersion() {
        assertEquals("1.0.0", module.getVersion());
    }
    
    @Test
    public void testInitialize() {
        // Clear the registry first to ensure a clean state
        // Note: In a real application, you would use a mock registry instead
        OperationRegistry.getInstance().getOperationSymbols().clear();
        
        // Initialize the module
        module.initialize(registry);
        
        // Check that the power operation is registered
        assertTrue(registry.hasOperation("^"));
        assertNotNull(registry.getOperation("^"));
        assertEquals("Power", registry.getOperation("^").getName());
    }
}