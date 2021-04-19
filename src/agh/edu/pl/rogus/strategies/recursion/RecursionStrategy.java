package agh.edu.pl.rogus.strategies.recursion;

import agh.edu.pl.rogus.constants.Constants;
import agh.edu.pl.rogus.strategies.FizzBuzzAbstract;

public class RecursionStrategy extends FizzBuzzAbstract {

    public RecursionStrategy(String name) {
        this.name = name;
        System.out.println(name);
    }

    @Override
    public void print(int from, int to) {
        if (isFizz(from)) System.out.print(Constants.FIZZ);
        if (isBuzz(from))  System.out.println(Constants.BUZZ);
        if (isOther(from)) System.out.println(from);
        if (from < to) print(++from, to);
    }
}
