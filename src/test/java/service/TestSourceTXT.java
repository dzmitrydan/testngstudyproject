package service;

import model.TestData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSourceTXT implements TestSource {

    @Override
    public List<TestData> readData(String filePath, String fileName) {
        File fileToRead = new File(filePath + File.separator + fileName);
        List<TestData> listData = new ArrayList<>();

        try (FileReader reader = new FileReader(fileToRead);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            List<String> list = new ArrayList<>();
            bufferedReader.lines().forEach(list::add);
            list.forEach(s -> listData.add(converterDataStringToObject(s)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listData;
    }

    private TestData converterDataStringToObject(String string) {
        String[] arrayString = string.split(" ");
        String testClassName = arrayString[0].replace(",", "");
        String[] arrayString2 = arrayString[1].split(",");
        String methodName = arrayString2[0];
        String[] methodParameters = arrayString2[1].split(";");

        TestData data = new TestData();
        data.setTestClassName(testClassName);
        data.setMethodName(methodName);
        data.setMethodParameters(methodParameters);
        return data;
    }

}
