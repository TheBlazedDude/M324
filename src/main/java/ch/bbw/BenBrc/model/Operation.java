package ch.bbw.BenBrc.model;

/**
 * Interface for calculator operations.
 * This allows for extending the calculator with new operations.
 */
public interface Operation {
    
    /**
     * Gets the symbol representing this operation.
     * 
     * @return the operation symbol (e.g., "+", "-", "*", "/")
     */
    String getSymbol();
    
    /**
     * Gets the name of this operation.
     * 
     * @return the operation name (e.g., "Addition", "Subtraction")
     */
    String getName();
    
    /**
     * Performs the operation on the given operands.
     * 
     * @param operands the operands for the operation
     * @return the result of the operation
     * @throws ArithmeticException if the operation cannot be performed
     */
    double perform(double... operands) throws ArithmeticException;
}