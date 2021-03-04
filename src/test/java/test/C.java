package test;

import model.CounterSingleton;
import test.base.BaseTest;
import test.base.CommonCondition;

public class C extends CommonCondition implements BaseTest {

    public void method1(String param1) {
        System.out.println(getClass().getName() + ", method1," + param1);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
        System.out.println(counter.getClass() + ": hashCode=" + counter.hashCode());
    }

    public void method2(String param1, String param2) {
        System.out.println(getClass().getName() + ", method2," + param1 + ";" + param2);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
        System.out.println(counter.getClass() + ": hashCode=" + counter.hashCode());
    }
}
