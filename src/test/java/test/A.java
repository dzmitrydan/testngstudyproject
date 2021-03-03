package test;

import model.CounterSingleton;
import test.base.BaseTest;
import test.base.TestCommonCondition;


public class A extends TestCommonCondition implements BaseTest {

    public void method1(String param1) {
        System.out.println(getClass().getName() + ", method1," + param1);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
    }

    public void method2(String param1, String param2) {
        System.out.println(getClass().getName() + ", method2," + param1 + ";" + param2);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
    }

    public void method3(String param1, String param2) {
        System.out.println(getClass().getName() + ", method3," + param1 + ";" + param2);
        System.out.println("Classic Singleton: number = " + CounterSingleton.getInstance().getNumber());
        System.out.println("Guice Singleton: number = " + counter.getNumber());
    }
}
