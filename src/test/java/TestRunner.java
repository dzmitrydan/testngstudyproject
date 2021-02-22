import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import service.ExcelFileReader;
import service.TestBuilder;

import java.io.IOException;
import java.util.*;

public class TestRunner {
    public static void main(String[] args) throws IOException {
        ExcelFileReader fileReader = new ExcelFileReader();
        List<XmlSuite> suites = new ArrayList<>();
        fileReader.readExcelFile("src/test/resources", "testdata.xlsx", "Sheet1")
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
