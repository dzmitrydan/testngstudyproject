import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import service.*;
import java.util.*;

public class TestRunner {
    private static final String filePath = "src/test/resources";
    private static final String fileName = "testdata.xlsx";

    public static void main(String[] args) {

        List<XmlSuite> suites = new ArrayList<>();

        TestSource testSource = FileExtensionNameSelector.getFileReader(fileName);
        testSource.readData(filePath, fileName)
                .forEach(data -> suites.add(TestBuilder.buildTestSuite(
                        data.getTestClassName(),
                        data.getMethodName(),
                        data.getMethodParameters()
                )));

        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}
