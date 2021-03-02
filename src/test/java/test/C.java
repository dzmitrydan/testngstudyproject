package test;

public class C implements BaseTest {

    public void method1(String param1) {
        System.out.println(getClass().getName() + ", method1,"  + param1);
    }

    public void method2(String param1, String param2) {
        System.out.println(getClass().getName() + ", method2," + param1 + ";" + param2);
    }
}
