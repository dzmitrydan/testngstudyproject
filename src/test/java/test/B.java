package test;

import model.Counter;
import model.CounterSingleton;
import test.base.BaseTest;

public class B implements BaseTest {

    public void method1(String param1) {

        Counter counter = ReflectionTestRunner.injector.getInstance(Counter.class);

        System.out.println(getClass().getName() + ", method1," + param1);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
        System.out.println(counter.getClass() + ": hashCode=" + counter.hashCode());
    }

    public void method2(String param1, String param2) {

        Counter counter = ReflectionTestRunner.injector.getInstance(Counter.class);

        System.out.println(getClass().getName() + ", method2," + param1 + ";" + param2);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
        System.out.println(counter.getClass() + ": hashCode=" + counter.hashCode());
    }
}
