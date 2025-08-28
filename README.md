# Simple Calculator

A simple calculator application with a JavaFX UI that can be extended with modules.

## Features

- Basic mathematical operations: addition, subtraction, multiplication, division
- Extensible architecture that allows adding new operations through modules
- Sample power operation module included
- Square root operation module included as a Git submodule

## Project Structure

The project is organized into the following packages:

- `ch.bbw.BenBrc`: Contains the main application class
- `ch.bbw.BenBrc.model`: Contains the calculator model and operation interfaces
- `ch.bbw.BenBrc.model.operations`: Contains the concrete operation implementations
- `ch.bbw.BenBrc.module`: Contains the module system

The project also includes a Git submodule:

- `calculator-operations-module`: Contains additional operations for the calculator

## How to Use

### Running the Application

There are several ways to run the application:

1. **Using the provided scripts:**
   - On Windows: Double-click the `run.bat` file or run it from the command line
   - On Unix-like systems: Run `./run.sh` from the terminal (make sure it's executable with `chmod +x run.sh`)

2. **Using Maven directly:**
   ```
   mvn javafx:run
   ```

3. **Building and running the JAR:**
   ```
   mvn package
   java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base -jar target/M450_-1.0-SNAPSHOT.jar
   ```
   Note: Replace `/path/to/javafx-sdk` with the actual path to your JavaFX SDK.

### JavaFX Runtime Requirements

This application requires JavaFX runtime components. If you encounter the error "JavaFX runtime components are missing", make sure you have JavaFX installed and properly configured.

### Using the Calculator

1. Use the calculator UI to perform calculations
2. Basic operations:
   - Addition: `+`
   - Subtraction: `-`
   - Multiplication: `*`
   - Division: `/`
3. Extended operations (if modules are loaded):
   - Power: `^`

## How to Extend

The calculator can be extended with new operations by creating modules. Here's how:

1. Create a new operation class that implements the `Operation` interface
2. Create a new module class that implements the `CalculatorModule` interface
3. Register the operation in the module's `initialize` method
4. Load the module in the application

### Using Git Submodules

You can also extend the calculator by adding Git submodules. Here's how:

1. Create a new Git repository for your calculator operations
2. Implement the operations and modules in the repository
3. Add the repository as a Git submodule to the main project:
   ```
   git submodule add <repository-url>
   ```
4. Update the main project to use the operations from the submodule

### Example: Adding a Square Root Operation

1. Create a `SquareRootOperation` class:

```java
public class SquareRootOperation implements Operation {

    @Override
    public String getSymbol() {
        return "sqrt";
    }

    @Override
    public String getName() {
        return "Square Root";
    }

    @Override
    public double perform(double... operands) throws ArithmeticException {
        if (operands.length < 1) {
            throw new ArithmeticException("Square root requires at least one operand");
        }

        if (operands[0] < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }

        return Math.sqrt(operands[0]);
    }
}
```

2. Create a `SquareRootModule` class:

```java
public class SquareRootModule implements CalculatorModule {

    @Override
    public String getName() {
        return "Square Root Module";
    }

    @Override
    public String getDescription() {
        return "Adds the square root operation to the calculator.";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public void initialize(OperationRegistry registry) {
        registry.registerOperation(new SquareRootOperation());
    }
}
```

3. Load the module in the application:

```java
ModuleManager.getInstance().loadModule(new SquareRootModule());
```

4. Update the UI to include a button for the new operation.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
