package service;

import model.TestData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestSourceEXCEL implements TestSource {
    private String sheetName = "Sheet1";

    @Override
    public List<TestData> readData(String filePath, String fileName) {
        List<TestData> listData = new ArrayList<>();

        File file = new File(filePath + File.separator + fileName);

        try {
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = null;
            String fileExtensionName = fileName.substring(fileName.indexOf("."));
            if (fileExtensionName.equals(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else if (fileExtensionName.equals(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            }

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

            for (int i = 1; i < rowCount + 1; i++) {
                TestData data = new TestData();
                Row row = sheet.getRow(i);
                data.setTestClassName(row.getCell(0).getStringCellValue());
                data.setMethodName(row.getCell(1).getStringCellValue());
                data.setMethodParameters(row.getCell(2).getStringCellValue().split(";"));
                listData.add(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listData;
    }
}
