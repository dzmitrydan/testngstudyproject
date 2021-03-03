package model;

public class CounterOrdinary implements Counter {
    private int number;

    @Override
    public int getNumber() {
        return ++number;
    }
}
