import com.google.inject.Guice;
import com.google.inject.Injector;
import module.ParentModule;
import service.FileExtensionNameSelector;
import service.ParameterBuilderForReflection;
import test.base.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTestRunner {

    private static final String filePath = "src/test/resources";
    private static final String fileName = "testdata.txt";

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ParentModule());

        FileExtensionNameSelector.getFileReader(fileName).readData(filePath, fileName).forEach(data -> {
            System.out.println("------------------------");
            System.out.println("TestSuite" + data.getTestClassName());

            try {

                Class<?> testClass = Class.forName("test." + data.getTestClassName());
                BaseTest testObject = (BaseTest) injector.getInstance(testClass);

                Class<?>[] paramTypes = ParameterBuilderForReflection.createParamsTypes(data.getMethodParameters());

                Method method = testClass.getMethod(data.getMethodName(), paramTypes);
                method.invoke(testObject, (Object[]) data.getMethodParameters());

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
