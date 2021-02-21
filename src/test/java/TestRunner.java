import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import service.TextFileReader;
import service.TestBuilder;

import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        TextFileReader textFileReader = new TextFileReader();
        List<XmlSuite> suites = new ArrayList<>();
        textFileReader
                .readTextFile("src/test/resources/testdata.txt")
                .forEach(data -> suites.add(TestBuilder.suiteBuilder(
                        data.getTestClassName(),
                        data.getMethodName(),
                        data.getMethodParameters()
                )));
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}
