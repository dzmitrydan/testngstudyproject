package model;

public class CounterSingleton implements Counter {

    private static CounterSingleton counter;
    private int number;

    private CounterSingleton() {
    }

    public static CounterSingleton getInstance() {
        if (counter == null) {
            counter = new CounterSingleton();
        }
        return counter;
    }

    @Override
    public int getNumber() {
        return ++number;
    }
}
