package ch.bbw.BenBrc.model.operations;

import ch.bbw.BenBrc.model.Operation;

/**
 * Power operation implementation.
 * This is an example of an extension operation that raises a number to a power.
 */
public class PowerOperation implements Operation {
    
    @Override
    public String getSymbol() {
        return "^";
    }
    
    @Override
    public String getName() {
        return "Power";
    }
    
    @Override
    public double perform(double... operands) throws ArithmeticException {
        if (operands.length < 2) {
            throw new ArithmeticException("Power operation requires at least two operands");
        }
        
        double base = operands[0];
        double exponent = operands[1];
        
        return Math.pow(base, exponent);
    }
}