package service;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBuilder {

    public static XmlSuite suiteBuilder(String testClassName, String methodName, String[] methodParameters) {
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
        int keyNumber = 0;
        for (int i = 0; i < array.length; i++) {
            map.put("param" + ++keyNumber, array[i]);
        }
        return map;
    }
}
