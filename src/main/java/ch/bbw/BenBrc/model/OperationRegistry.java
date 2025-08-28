package ch.bbw.BenBrc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Registry for calculator operations.
 * This class manages the available operations and allows for dynamically adding new operations.
 */
public class OperationRegistry {
    private static OperationRegistry instance;
    private final Map<String, Operation> operations = new HashMap<>();
    
    private OperationRegistry() {
        // Private constructor to enforce singleton pattern
    }
    
    /**
     * Gets the singleton instance of the OperationRegistry.
     * 
     * @return the OperationRegistry instance
     */
    public static synchronized OperationRegistry getInstance() {
        if (instance == null) {
            instance = new OperationRegistry();
        }
        return instance;
    }
    
    /**
     * Registers an operation.
     * 
     * @param operation the operation to register
     */
    public void registerOperation(Operation operation) {
        operations.put(operation.getSymbol(), operation);
    }
    
    /**
     * Gets an operation by its symbol.
     * 
     * @param symbol the operation symbol
     * @return the operation, or null if not found
     */
    public Operation getOperation(String symbol) {
        return operations.get(symbol);
    }
    
    /**
     * Gets all registered operation symbols.
     * 
     * @return a set of operation symbols
     */
    public Set<String> getOperationSymbols() {
        return operations.keySet();
    }
    
    /**
     * Checks if an operation with the given symbol is registered.
     * 
     * @param symbol the operation symbol
     * @return true if the operation is registered, false otherwise
     */
    public boolean hasOperation(String symbol) {
        return operations.containsKey(symbol);
    }
}