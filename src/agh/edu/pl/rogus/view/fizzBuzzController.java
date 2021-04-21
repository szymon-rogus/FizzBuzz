package agh.edu.pl.rogus.view;

import agh.edu.pl.rogus.strategies.FizzBuzzStrategy;
import agh.edu.pl.rogus.strategies.recursion.RecursionStrategy;
import agh.edu.pl.rogus.strategies.streams.ForEachStrategy;
import agh.edu.pl.rogus.strategies.streams.MapStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class fizzBuzzController {

    private FizzBuzzStrategy fizzBuzzStrategy;

    @FXML
    private TextField strategyNameField;

    @FXML
    private Text noStrategy;

    @FXML
    private Text noFromValue;

    @FXML
    private Text noToValue;

    @FXML
    private TextField fromField;

    @FXML
    private TextField toField;

    @FXML
    private Button fizzBuzzButton;

    @FXML
    private Button recursionStrategyButton;

    @FXML
    private Button forEachStrategyButton;

    @FXML
    private Button mapStrategyButton;

    @FXML
    private TextArea textArea;

    public void initialize() {

        strategyNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            noStrategy.visibleProperty().set(false);
        });

        fromField.textProperty().addListener((observable, oldValue, newValue) -> {
            parseIntegerField(noFromValue, newValue);
        });

        toField.textProperty().addListener((observable, oldValue, newValue) -> {
            parseIntegerField(noToValue, newValue);
        });

        fizzBuzzButton.disableProperty().bind(
                noStrategy.visibleProperty()
                        .or(noFromValue.visibleProperty())
                        .or(noToValue.visibleProperty())
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
    public void handleFizzBuzz(ActionEvent actionEvent) {
        try {
            textArea.clear();
            fizzBuzzStrategy.print(getFieldValue(fromField), getFieldValue(toField), textArea);
        } catch (NullPointerException e) {
            noStrategy.visibleProperty().set(true);
        }
    }

    private int getFieldValue(TextField field) {
        return Integer.parseInt(field.getText());
    }

    @FXML
    public void handleRecursionStrategyButton(ActionEvent actionEvent) {
        fizzBuzzStrategy = new RecursionStrategy();
        updateStrategyLabel();
    }

    @FXML
    private void handleForEachStrategyButton(ActionEvent actionEvent) {
        fizzBuzzStrategy = new ForEachStrategy();
        updateStrategyLabel();
    }

    @FXML
    private void handleMapStrategyButton(ActionEvent actionEvent) {
        fizzBuzzStrategy = new MapStrategy();
        updateStrategyLabel();
    }

    private void updateStrategyLabel() {
        strategyNameField.setText(fizzBuzzStrategy.getClass().getSimpleName());
    }
}
