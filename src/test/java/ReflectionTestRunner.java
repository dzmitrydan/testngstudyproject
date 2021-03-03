import service.*;
import test.base.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTestRunner {
    private static final String filePath = "src/test/resources";
    private static final String fileName = "testdata.txt";

    public static void main(String[] args) {

        FileExtensionNameSelector.getFileReader(fileName).readData(filePath, fileName).forEach(data -> {
            System.out.println("------------------------");
            System.out.println("TestSuite" + data.getTestClassName());
            BaseTest testObject = TestClassProvider.TestClassByName(data.getTestClassName());

            Class testClass = testObject.getClass();
            Class[] paramTypes = ParameterBuilderForReflection.createParamsTypes(data.getMethodParameters());

            try {
                Method method = testClass.getMethod(data.getMethodName(), paramTypes);
                method.invoke(testObject, data.getMethodParameters());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
