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
    private TextField strategyName;

    @FXML
    private Text noStrategy;

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
        noStrategy.visibleProperty().set(false);
        strategyName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                fizzBuzzStrategy = null;
            }
        });
    }

    @FXML
    public void handleFizzBuzz(ActionEvent actionEvent) {
        try {
            fizzBuzzStrategy.print(getFieldValue(fromField), getFieldValue(toField), textArea);
        } catch (NullPointerException e) {
            noStrategy.visibleProperty().set(true);
        }
    }

    private int getFieldValue(TextField field) {
        if (!field.getText().isEmpty()) {
            return Integer.parseInt(field.getText());
        }
        return 0;
    }

    @FXML
    public void handleRecursionStrategyButton(ActionEvent actionEvent) {
        fizzBuzzStrategy = new RecursionStrategy();
        strategyName.setText(fizzBuzzStrategy.getClass().getSimpleName());
        noStrategy.visibleProperty().set(false);
    }

    @FXML
    private void handleForEachStrategyButton(ActionEvent actionEvent) {
        fizzBuzzStrategy = new ForEachStrategy();
        strategyName.setText(fizzBuzzStrategy.getClass().getSimpleName());
        noStrategy.visibleProperty().set(false);
    }

    @FXML
    private void handleMapStrategyButton(ActionEvent actionEvent) {
        fizzBuzzStrategy = new MapStrategy();
        strategyName.setText(fizzBuzzStrategy.getClass().getSimpleName());
        noStrategy.visibleProperty().set(false);
    }
}
