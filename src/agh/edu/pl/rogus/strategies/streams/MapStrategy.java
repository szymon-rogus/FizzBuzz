package agh.edu.pl.rogus.strategies.streams;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;

import java.util.stream.IntStream;

public class MapStrategy extends FizzBuzzAbstract {

    public MapStrategy(String name) {
        this.name = name;
    }

    @Override
    public void print(int from, int to) {
        System.out.println(name);
        IntStream.rangeClosed(from, to)
                .mapToObj(number -> {
                    if (isFizzBuzz(number)) return Constants.FIZZBUZZ;
                    if (isFizz(number)) return Constants.FIZZ;
                    if (isBuzz(number)) return Constants.BUZZ;
                    return String.valueOf(number);
                })
                .forEach(System.out::println);
    }
}
