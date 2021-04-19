package agh.edu.pl.rogus.strategies.recursion;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;

import javafx.scene.control.TextArea;

public class RecursionStrategy extends FizzBuzzAbstract {

    @Override
    public void print(int from, int to, TextArea textArea) {
        if (isFizz(from)) textArea.appendText(Constants.FIZZ);
        if (isBuzz(from))  textArea.appendText(Constants.BUZZ);
        if (isOther(from)) textArea.appendText(String.valueOf(from));
        textArea.appendText("\n");
        if (from < to) print(++from, to, textArea);
    }
}
