package ch.bbw.BenBrc.module;

/**
 * Loader for submodules.
 * This class loads modules from Git submodules.
 */
public class SubmoduleLoader {
    
    private static SubmoduleLoader instance;
    private final ModuleManager moduleManager;
    
    private SubmoduleLoader() {
        moduleManager = ModuleManager.getInstance();
    }
    
    /**
     * Gets the singleton instance of the SubmoduleLoader.
     * 
     * @return the SubmoduleLoader instance
     */
    public static synchronized SubmoduleLoader getInstance() {
        if (instance == null) {
            instance = new SubmoduleLoader();
        }
        return instance;
    }
    
    /**
     * Loads all modules from submodules.
     */
    public void loadSubmodules() {
        // Load the square root module from the calculator-operations-module submodule
        moduleManager.loadModule(new ch.bbw.BenBrc.module.SquareRootModule());
        
        System.out.println("Loaded modules from submodules");
    }
}