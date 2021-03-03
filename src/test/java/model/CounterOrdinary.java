package model;

public class CounterOrdinary implements Counter {
    private static int number;

    @Override
    public int getNumber() {
        return ++number;
    }
}
