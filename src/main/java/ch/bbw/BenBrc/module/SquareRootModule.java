package ch.bbw.BenBrc.module;

import ch.bbw.BenBrc.model.OperationRegistry;
import ch.bbw.BenBrc.model.operations.SquareRootOperation;

/**
 * Module that adds the square root operation to the calculator.
 * 
 * This class is copied from the calculator-operations-module submodule.
 */
public class SquareRootModule implements CalculatorModule {
    
    @Override
    public String getName() {
        return "Square Root Module";
    }
    
    @Override
    public String getDescription() {
        return "Adds the square root operation to the calculator.";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
    
    @Override
    public void initialize(OperationRegistry registry) {
        registry.registerOperation(new SquareRootOperation());
    }
}