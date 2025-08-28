package ch.bbw.BenBrc.model.operations;

import ch.bbw.BenBrc.model.Operation;

/**
 * Division operation implementation.
 */
public class DivisionOperation implements Operation {
    
    @Override
    public String getSymbol() {
        return "/";
    }
    
    @Override
    public String getName() {
        return "Division";
    }
    
    @Override
    public double perform(double... operands) throws ArithmeticException {
        if (operands.length < 2) {
            throw new ArithmeticException("Division requires at least two operands");
        }
        
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            if (operands[i] == 0) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
            result /= operands[i];
        }
        
        return result;
    }
}