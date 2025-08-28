package ch.bbw.BenBrc;

import javafx.application.Application;

/**
 * Launcher class for the calculator application.
 * This class is used to launch the JavaFX application with the correct module path.
 * 
 * Since Java 11, JavaFX is no longer bundled with the JDK and needs to be explicitly
 * included in the module path. This launcher class ensures that the JavaFX modules
 * are properly loaded before starting the application.
 */
public class Launcher {

    /**
     * Main method that launches the JavaFX application.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Launch the JavaFX application using the Application.launch method
        // This ensures that the JavaFX runtime is properly initialized
        Application.launch(App.class, args);
    }
}
