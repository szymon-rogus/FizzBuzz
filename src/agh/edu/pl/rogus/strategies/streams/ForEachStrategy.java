package agh.edu.pl.rogus.strategies.streams;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;

import javafx.scene.control.TextArea;
import java.util.stream.IntStream;

public class ForEachStrategy extends FizzBuzzAbstract {

    @Override
    public void print(int from, int to, TextArea textArea) {
        IntStream.rangeClosed(from, to)
                .forEach(number -> {
                    if (isFizz(number)) textArea.appendText(Constants.FIZZ);
                    if (isBuzz(number)) textArea.appendText(Constants.BUZZ);
                    if (isOther(number)) textArea.appendText(String.valueOf(number));
                    textArea.appendText("\n");
                });
    }
}
