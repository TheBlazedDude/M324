package ch.bbw.BenBrc.model.operations;

import ch.bbw.BenBrc.model.Operation;

/**
 * Multiplication operation implementation.
 */
public class MultiplicationOperation implements Operation {
    
    @Override
    public String getSymbol() {
        return "*";
    }
    
    @Override
    public String getName() {
        return "Multiplication";
    }
    
    @Override
    public double perform(double... operands) throws ArithmeticException {
        if (operands.length < 2) {
            throw new ArithmeticException("Multiplication requires at least two operands");
        }
        
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result *= operands[i];
        }
        
        return result;
    }
}