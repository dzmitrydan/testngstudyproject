import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        List<XmlSuite> suites = new ArrayList<>();
        Arrays.stream(args).forEach(s -> suites.add(suiteBuilder(s)));
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }

    private static XmlSuite suiteBuilder(String testSuiteName) {
        XmlSuite suite = new XmlSuite();
        suite.setName("TestSuite" + testSuiteName);
        XmlTest test = new XmlTest(suite);
        test.setName("Test" + testSuiteName);
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("test.Test" + testSuiteName));
        test.setXmlClasses(classes);
        return suite;
    }
}
