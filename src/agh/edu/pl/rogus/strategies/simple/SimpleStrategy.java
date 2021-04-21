package agh.edu.pl.rogus.strategies.simple;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;
import javafx.scene.control.TextArea;

public class SimpleStrategy extends FizzBuzzAbstract {

    @Override
    public void print(int from, int to, TextArea textArea) {
        for (int i = from; i <= to; i++) {
            if (i % 15 == 0) textArea.appendText(Constants.FIZZBUZZ);
            else if (i % 3 == 0) textArea.appendText(Constants.FIZZ);
            else if (i % 5 == 0) textArea.appendText(Constants.BUZZ);
            else textArea.appendText(String.valueOf(i));
            textArea.appendText("\n");
        }
    }
}
