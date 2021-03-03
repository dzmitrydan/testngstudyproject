package service;

import test.*;
import test.base.BaseTest;

public class TestClassProvider {

    public static BaseTest TestClassByName(String testClassName) {

        BaseTest testObject = null;

        switch (testClassName) {
            case "A":
                testObject = new A();
                break;
            case "B":
                testObject = new B();
                break;
            case "C":
                testObject = new C();
                break;
            default:
                System.out.println("Test class name '" + testClassName + "' does not exist");
                break;
        }
        return testObject;
    }
}
