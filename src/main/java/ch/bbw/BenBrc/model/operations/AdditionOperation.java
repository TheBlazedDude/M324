package ch.bbw.BenBrc.model.operations;

import ch.bbw.BenBrc.model.Operation;

/**
 * Addition operation implementation.
 */
public class AdditionOperation implements Operation {
    
    @Override
    public String getSymbol() {
        return "+";
    }
    
    @Override
    public String getName() {
        return "Addition";
    }
    
    @Override
    public double perform(double... operands) throws ArithmeticException {
        if (operands.length < 2) {
            throw new ArithmeticException("Addition requires at least two operands");
        }
        
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result += operands[i];
        }
        
        return result;
    }
}