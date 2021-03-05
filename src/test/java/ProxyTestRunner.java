import javassist.util.proxy.ProxyFactory;
import model.TestData;
import org.testng.annotations.Test;
import test.GoogleTest;
import test.TestInterface;
import test.YandexTest;

import java.util.ArrayList;
import java.util.List;

public class ProxyTestRunner {

    private static final String param = "google";
    private static List<TestData> listData;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        listData = new ArrayList<>();

        googleTest().searchTest(param);
        yandexTest().searchTest(param);
        googleTest().siteSearchTest(param);

        printListData();
    }

    private static GoogleTest googleTest() throws InstantiationException, IllegalAccessException {
        return objectType(GoogleTest.class);
    }

    private static YandexTest yandexTest() throws InstantiationException, IllegalAccessException {
        return objectType(YandexTest.class);
    }

    private static <K> K objectType(Class<K> objectTypeClass) throws IllegalAccessException, InstantiationException {

        TestInterface testObject = null;
        if (objectTypeClass.getSimpleName().equals("GoogleTest")) {
            testObject = (GoogleTest) objectTypeClass.newInstance();
        } else if (objectTypeClass.getSimpleName().equals("YandexTest")) {
            testObject = (YandexTest) objectTypeClass.newInstance();
        }

        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(objectTypeClass);

        factory.setFilter(m -> null != m.getAnnotation(Test.class));
        try {
            TestInterface finalTestObject = testObject;
            return (K) factory.create(new Class<?>[0], new Object[0], (self, thisMethod, proceed, args) -> {
                TestData data = new TestData();
                data.setTestClassName(finalTestObject.getClass().getSimpleName());
                data.setMethodName(thisMethod.getName());
                data.setMethodParameters(new String[]{param});
                listData.add(data);
                return null;
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void printListData() {
        listData.stream().forEach(d -> System.out.println(d.toString()));
    }

}
