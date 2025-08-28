package ch.bbw.BenBrc.model.operations;

import ch.bbw.BenBrc.model.Operation;

/**
 * Subtraction operation implementation.
 */
public class SubtractionOperation implements Operation {
    
    @Override
    public String getSymbol() {
        return "-";
    }
    
    @Override
    public String getName() {
        return "Subtraction";
    }
    
    @Override
    public double perform(double... operands) throws ArithmeticException {
        if (operands.length < 2) {
            throw new ArithmeticException("Subtraction requires at least two operands");
        }
        
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result -= operands[i];
        }
        
        return result;
    }
}