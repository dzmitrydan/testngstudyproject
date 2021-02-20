import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        Map<String, String> testData = dataParser(args);
        List<XmlSuite> suites = new ArrayList<>();
        testData.keySet().stream().forEach(key -> suites.add(suiteBuilder(key, testData.get(key))));
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }

    private static XmlSuite suiteBuilder(String testClassName, String methodName) {
        XmlSuite suite = new XmlSuite();
        suite.setName("TestSuite" + testClassName);
        XmlTest test = new XmlTest(suite);
        test.setName("Test" + testClassName);
        List<XmlClass> classes = new ArrayList<>();
        XmlClass testClass = new XmlClass("test.Test" + testClassName);
        List<String> excludedMethods = new ArrayList<>();
        excludedMethods.add("method" + methodName);
        testClass.setExcludedMethods(excludedMethods);
        classes.add(testClass);
        test.setXmlClasses(classes);
        return suite;
    }

    private static Map<String, String> dataParser(String[] dataArray) {
        Map<String, String> dataMap = new HashMap<>();
        Arrays.stream(dataArray).forEach(v -> {
            String[] data = v.split("\\.");
            dataMap.put(data[0], data[1]);
        });
        return dataMap;
    }
}
