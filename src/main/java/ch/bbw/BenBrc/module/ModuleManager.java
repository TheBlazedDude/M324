package ch.bbw.BenBrc.module;

import ch.bbw.BenBrc.model.OperationRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager for calculator modules.
 * This class loads and manages calculator modules.
 */
public class ModuleManager {
    private static ModuleManager instance;
    private final List<CalculatorModule> modules = new ArrayList<>();
    private final OperationRegistry registry;
    
    private ModuleManager() {
        registry = OperationRegistry.getInstance();
    }
    
    /**
     * Gets the singleton instance of the ModuleManager.
     * 
     * @return the ModuleManager instance
     */
    public static synchronized ModuleManager getInstance() {
        if (instance == null) {
            instance = new ModuleManager();
        }
        return instance;
    }
    
    /**
     * Loads a module.
     * 
     * @param module the module to load
     */
    public void loadModule(CalculatorModule module) {
        modules.add(module);
        module.initialize(registry);
        System.out.println("Loaded module: " + module.getName() + " v" + module.getVersion());
    }
    
    /**
     * Gets all loaded modules.
     * 
     * @return a list of loaded modules
     */
    public List<CalculatorModule> getModules() {
        return new ArrayList<>(modules);
    }
    
    /**
     * Gets a module by name.
     * 
     * @param name the module name
     * @return the module, or null if not found
     */
    public CalculatorModule getModule(String name) {
        for (CalculatorModule module : modules) {
            if (module.getName().equals(name)) {
                return module;
            }
        }
        return null;
    }
}