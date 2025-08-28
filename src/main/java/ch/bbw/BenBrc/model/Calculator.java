package ch.bbw.BenBrc.model;

import ch.bbw.BenBrc.model.operations.AdditionOperation;
import ch.bbw.BenBrc.model.operations.DivisionOperation;
import ch.bbw.BenBrc.model.operations.MultiplicationOperation;
import ch.bbw.BenBrc.model.operations.SubtractionOperation;

/**
 * Calculator model that provides mathematical operations.
 * This class uses the Operation interface and OperationRegistry to support extensibility.
 */
public class Calculator {

    private final OperationRegistry registry;

    /**
     * Creates a new Calculator with the basic operations.
     */
    public Calculator() {
        registry = OperationRegistry.getInstance();

        // Register the basic operations
        registry.registerOperation(new AdditionOperation());
        registry.registerOperation(new SubtractionOperation());
        registry.registerOperation(new MultiplicationOperation());
        registry.registerOperation(new DivisionOperation());
    }

    /**
     * Performs an operation using the given symbol and operands.
     * 
     * @param symbol the operation symbol
     * @param operands the operands for the operation
     * @return the result of the operation
     * @throws IllegalArgumentException if the operation is not supported
     * @throws ArithmeticException if the operation cannot be performed
     */
    public double performOperation(String symbol, double... operands) {
        Operation operation = registry.getOperation(symbol);
        if (operation == null) {
            throw new IllegalArgumentException("Unsupported operation: " + symbol);
        }
        return operation.perform(operands);
    }

    /**
     * Adds two numbers.
     * 
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return performOperation("+", a, b);
    }

    /**
     * Subtracts the second number from the first.
     * 
     * @param a first number
     * @param b second number
     * @return the difference of a and b
     */
    public double subtract(double a, double b) {
        return performOperation("-", a, b);
    }

    /**
     * Multiplies two numbers.
     * 
     * @param a first number
     * @param b second number
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return performOperation("*", a, b);
    }

    /**
     * Divides the first number by the second.
     * 
     * @param a first number
     * @param b second number
     * @return the quotient of a and b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        return performOperation("/", a, b);
    }

    /**
     * Checks if an operation with the given symbol is supported.
     * 
     * @param symbol the operation symbol
     * @return true if the operation is supported, false otherwise
     */
    public boolean supportsOperation(String symbol) {
        return registry.hasOperation(symbol);
    }
}
