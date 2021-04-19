package agh.edu.pl.rogus.strategies.streams;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;

import javafx.scene.control.TextArea;
import java.util.stream.IntStream;

public class MapStrategy extends FizzBuzzAbstract {

    @Override
    public void print(int from, int to, TextArea textArea) {
        IntStream.rangeClosed(from, to)
                .mapToObj(number -> {
                    if (isFizzBuzz(number)) return Constants.FIZZBUZZ;
                    if (isFizz(number)) return Constants.FIZZ;
                    if (isBuzz(number)) return Constants.BUZZ;
                    return String.valueOf(number);
                })
                .forEach(number -> textArea.appendText(number+"\n"));
    }
}
