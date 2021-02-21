package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C {

    @Parameters({"param1"})
    @Test
    public void method1(String param1) {
        System.out.println(getClass().getName() + ", method1,"  + param1);
    }

    @Parameters({"param1", "param2"})
    @Test
    public void method2(String param1, String param2) {
        System.out.println(getClass().getName() + ", method2," + param1 + ";" + param2);
    }
}
