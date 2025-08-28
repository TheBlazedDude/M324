package ch.bbw.BenBrc.module;

import ch.bbw.BenBrc.model.OperationRegistry;
import ch.bbw.BenBrc.model.operations.PowerOperation;

/**
 * Sample module that adds the power operation to the calculator.
 */
public class PowerModule implements CalculatorModule {
    
    @Override
    public String getName() {
        return "Power Module";
    }
    
    @Override
    public String getDescription() {
        return "Adds the power operation (^) to the calculator.";
    }
    
    @Override
    public String getVersion() {
        return "1.0.0";
    }
    
    @Override
    public void initialize(OperationRegistry registry) {
        registry.registerOperation(new PowerOperation());
    }
}