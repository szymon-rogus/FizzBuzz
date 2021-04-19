package agh.edu.pl.rogus.strategies;

import agh.edu.pl.rogus.constants.Constants;

public abstract class FizzBuzzAbstract implements FizzBuzzStrategy {

    protected String name;

    protected boolean isFizz(int number) {
        return number % Constants.THREE == 0;
    }

    protected boolean isBuzz(int number) {
        return number % Constants.FIVE == 0;
    }

    protected boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }

    protected boolean isOther(int number) {
        return number % Constants.THREE != 0  && number % Constants.FIVE != 0;
    }
}
