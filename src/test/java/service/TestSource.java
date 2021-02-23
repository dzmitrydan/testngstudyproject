package service;

import model.TestData;
import java.util.List;

public interface TestSource {

    List<TestData> readData(String filePath, String fileName);
}
