package agh.edu.pl.rogus.strategies.streams;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;

import java.util.stream.IntStream;

public class ForEachStrategy extends FizzBuzzAbstract {

    public ForEachStrategy(String name) {
        this.name = name;
    }

    @Override
    public void print(int from, int to) {
        System.out.print(name);
        IntStream.rangeClosed(from, to)
                .forEach(number -> {
                    System.out.println();
                    if (isFizz(number)) System.out.print(Constants.FIZZ);
                    if (isBuzz(number)) System.out.print(Constants.BUZZ);
                    if (isOther(number)) System.out.print(number);
                });
    }
}
