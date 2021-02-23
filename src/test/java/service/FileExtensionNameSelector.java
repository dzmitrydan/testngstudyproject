package service;

public class FileExtensionNameSelector {

    public static TestSource getFileReader(String fileName) {
        TestSource fileReader = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        switch (fileExtensionName) {
            case ".txt":
                fileReader = new TestSourceTXT();
                break;
            case ".xls":
            case ".xlsx":
                fileReader = new TestSourceEXCEL();
                break;
            default:
                System.out.println(fileExtensionName + " - this data type is not maintained");
                break;
        }
        return fileReader;
    }
}
