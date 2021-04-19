package agh.edu.pl.rogus;

import agh.edu.pl.rogus.strategies.FizzBuzzStrategy;
import agh.edu.pl.rogus.strategies.recursion.RecursionStrategy;

public class Main {

    private static FizzBuzzStrategy fizzBuzzStrategy;

    public static void main(String[] args) {

        fizzBuzzStrategy = new RecursionStrategy("RecursionStrategy");

        fizzBuzzStrategy.print(1, 100);
    }
}
