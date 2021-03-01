package service;

import driver.ParentModule;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestBuilder {

    public static XmlSuite buildTestSuite(String testClassName, String methodName, String[] methodParameters) {
        XmlSuite suite = new XmlSuite();
        suite.setName("TestSuite" + testClassName);

        XmlTest test = new XmlTest(suite);
        test.setName(testClassName);

        List<XmlClass> classes = new ArrayList<>();
        XmlClass testClass = new XmlClass("test." + testClassName);

        List<XmlInclude> includedMethods = new ArrayList<>();
        XmlInclude xmlInclude = new XmlInclude(methodName);
        includedMethods.add(xmlInclude);
        testClass.setIncludedMethods(includedMethods);

        Map<String, String> parameters = setParameters(methodParameters);
        testClass.setParameters(parameters);
        classes.add(testClass);
        test.setXmlClasses(classes);

        return suite;
    }

    private static Map<String, String> setParameters(String[] array) {
        Map<String, String> map = new HashMap<>();
        AtomicInteger keyNumber = new AtomicInteger(0);
        Arrays.stream(array).forEach(parameter -> map.put("param" + keyNumber.incrementAndGet(), parameter));
        return map;
    }
}
