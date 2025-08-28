package ch.bbw.BenBrc;

import ch.bbw.BenBrc.model.Calculator;
import ch.bbw.BenBrc.module.ModuleManager;
import ch.bbw.BenBrc.module.PowerModule;
import ch.bbw.BenBrc.module.SquareRootModule;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Simple Calculator Application with JavaFX UI
 */
public class App extends Application {
    private Calculator calculator = new Calculator();
    private TextField display;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewInput = true;
    private ModuleManager moduleManager = ModuleManager.getInstance();

    public App() {
        // Load modules
        moduleManager.loadModule(new PowerModule());
        moduleManager.loadModule(new SquareRootModule());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create the display
        display = new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPrefHeight(50);
        display.setStyle("-fx-font-size: 20px;");

        // Create the button grid
        GridPane buttonGrid = createButtonGrid();

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(display, buttonGrid);

        // Scene
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            Button button = createButton(String.valueOf(i));
            int row = (9 - i) / 3 + 1;
            int col = (i - 1) % 3;
            if (i == 0) {
                grid.add(button, 1, 4);
            } else {
                grid.add(button, col, row);
            }
        }

        // Operation buttons
        grid.add(createButton("+"), 3, 1);
        grid.add(createButton("-"), 3, 2);
        grid.add(createButton("*"), 3, 3);
        grid.add(createButton("/"), 3, 4);
        grid.add(createButton("="), 2, 4);
        grid.add(createButton("C"), 0, 4);
        grid.add(createButton("."), 2, 3);

        // Add power button if the operation is supported
        if (calculator.supportsOperation("^")) {
            grid.add(createButton("^"), 0, 0);
        }

        // Add square root button if the operation is supported
        if (calculator.supportsOperation("sqrt")) {
            grid.add(createButton("sqrt"), 1, 0);
        }

        return grid;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(50, 50);
        button.setStyle("-fx-font-size: 18px;");

        button.setOnAction(e -> {
            String buttonText = button.getText();
            handleButtonPress(buttonText);
        });

        return button;
    }

    private void handleButtonPress(String buttonText) {
        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                handleNumberInput(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":  // Add support for power operation
                handleOperator(buttonText);
                break;
            case "sqrt":  // Add support for square root operation
                handleSquareRoot();
                break;
            case "=":
                calculateResult();
                break;
            case "C":
                clearCalculator();
                break;
        }
    }

    private void handleSquareRoot() {
        if (!currentInput.isEmpty()) {
            try {
                double operand = Double.parseDouble(currentInput);
                double result = calculator.performOperation("sqrt", operand);
                currentInput = formatResult(result);
                display.setText(currentInput);
                startNewInput = true;
            } catch (ArithmeticException e) {
                display.setText("Error: " + e.getMessage());
                clearCalculator();
            }
        }
    }

    private void handleNumberInput(String digit) {
        if (startNewInput) {
            currentInput = digit;
            startNewInput = false;
        } else {
            if (digit.equals(".") && currentInput.contains(".")) {
                return; // Prevent multiple decimal points
            }
            currentInput += digit;
        }
        display.setText(currentInput);
    }

    private void handleOperator(String op) {
        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                calculateResult();
            }
            firstOperand = Double.parseDouble(currentInput);
            operator = op;
            startNewInput = true;
        }
    }

    private void calculateResult() {
        if (operator.isEmpty() || startNewInput) {
            return;
        }

        double secondOperand = Double.parseDouble(currentInput);
        double result = 0;

        try {
            switch (operator) {
                case "+":
                    result = calculator.add(firstOperand, secondOperand);
                    break;
                case "-":
                    result = calculator.subtract(firstOperand, secondOperand);
                    break;
                case "*":
                    result = calculator.multiply(firstOperand, secondOperand);
                    break;
                case "/":
                    result = calculator.divide(firstOperand, secondOperand);
                    break;
                case "^":
                    result = calculator.performOperation("^", firstOperand, secondOperand);
                    break;
                default:
                    if (calculator.supportsOperation(operator)) {
                        result = calculator.performOperation(operator, firstOperand, secondOperand);
                    } else {
                        throw new IllegalArgumentException("Unsupported operation: " + operator);
                    }
            }

            currentInput = formatResult(result);
            display.setText(currentInput);
            operator = "";
            startNewInput = true;
        } catch (ArithmeticException e) {
            display.setText("Error: " + e.getMessage());
            clearCalculator();
        }
    }

    private String formatResult(double result) {
        // Remove trailing zeros for integer results
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.valueOf(result);
        }
    }

    private void clearCalculator() {
        currentInput = "";
        operator = "";
        firstOperand = 0;
        startNewInput = true;
        display.setText("0");
    }

    public static void main(String[] args) {
        // This method is called by the Launcher class
        // The Launcher class ensures that the JavaFX modules are properly loaded
        launch(args);
    }
}
