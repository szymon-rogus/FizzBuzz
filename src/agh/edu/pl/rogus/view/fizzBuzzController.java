package agh.edu.pl.rogus.view;

import agh.edu.pl.rogus.strategies.FizzBuzzStrategy;
import agh.edu.pl.rogus.strategies.recursion.RecursionStrategy;
import agh.edu.pl.rogus.strategies.simple.SimpleStrategy;
import agh.edu.pl.rogus.strategies.streams.ForEachStrategy;
import agh.edu.pl.rogus.strategies.streams.MapStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class fizzBuzzController {

    @FXML
    private FizzBuzzStrategy fizzBuzzStrategy;

    @FXML
    public Button recursionStrategyButton;

    @FXML
    public Button simpleStrategyButton;

    @FXML
    public Button forEachStrategyButton;

    @FXML
    public Button mapStrategyButton;

    @FXML
    private Text strategyNameField;

    @FXML
    private TextField fromField;

    @FXML
    private Text noFromValue;

    @FXML
    private TextField toField;

    @FXML
    private Text noToValue;

    @FXML
    private Button fizzBuzzButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextArea textArea;

    public void initialize() {

        handleSimpleStrategyButton();

        fromField.textProperty().addListener((observable, oldValue, newValue) -> {
            parseIntegerField(noFromValue, newValue);
        });

        toField.textProperty().addListener((observable, oldValue, newValue) -> {
            parseIntegerField(noToValue, newValue);
        });

        fizzBuzzButton.disableProperty().bind(
                noFromValue.visibleProperty().or(noToValue.visibleProperty())
        );

        clearButton.disableProperty().bind(
                textArea.textProperty().isEmpty()
        );
    }

    private void parseIntegerField(Text text, String newValue) {
        try {
            Integer.parseInt(newValue);
            text.visibleProperty().set(false);
        } catch (NumberFormatException e) {
            text.visibleProperty().set(true);
        }
    }

    @FXML
    public void handleFizzBuzz() {
        try {
            textArea.clear();
            fizzBuzzStrategy.print(getFieldValue(fromField), getFieldValue(toField), textArea);
        } catch (NullPointerException e) {
            // noStrategy.visibleProperty().set(true);
        }
    }

    private int getFieldValue(TextField field) {
        return Integer.parseInt(field.getText());
    }

    @FXML
    public void handleRecursionStrategyButton() {
        fizzBuzzStrategy = new RecursionStrategy();
        updateStrategyLabel();
    }

    @FXML
    public void handleSimpleStrategyButton() {
        fizzBuzzStrategy = new SimpleStrategy();
        updateStrategyLabel();
    }

    @FXML
    private void handleForEachStrategyButton() {
        fizzBuzzStrategy = new ForEachStrategy();
        updateStrategyLabel();
    }

    @FXML
    private void handleMapStrategyButton() {
        fizzBuzzStrategy = new MapStrategy();
        updateStrategyLabel();
    }

    private void updateStrategyLabel() {
        strategyNameField.setText(fizzBuzzStrategy.getClass().getSimpleName());
    }

    @FXML
    private void clearTextArea() {
        textArea.clear();
    }
}
