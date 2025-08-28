package ch.bbw.BenBrc.module;

import ch.bbw.BenBrc.model.OperationRegistry;

/**
 * Interface for calculator modules.
 * Modules can be used to extend the calculator with new operations.
 */
public interface CalculatorModule {
    
    /**
     * Gets the name of the module.
     * 
     * @return the module name
     */
    String getName();
    
    /**
     * Gets the description of the module.
     * 
     * @return the module description
     */
    String getDescription();
    
    /**
     * Gets the version of the module.
     * 
     * @return the module version
     */
    String getVersion();
    
    /**
     * Initializes the module.
     * This method is called when the module is loaded.
     * 
     * @param registry the operation registry
     */
    void initialize(OperationRegistry registry);
}