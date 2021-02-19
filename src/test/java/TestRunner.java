import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {

        List<XmlSuite> suites = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            XmlSuite suite = new XmlSuite();
            suite.setName("TestSuite" + args[i]);

            XmlTest test = new XmlTest(suite);
            test.setName("Test" +  args[i]);

            List<XmlClass> classes = new ArrayList<>();
            classes.add(new XmlClass("test.Test" + args[i]));
            test.setXmlClasses(classes) ;

            suites.add(suite);
        }

        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}
