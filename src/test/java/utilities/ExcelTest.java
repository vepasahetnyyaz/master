package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTest {
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/testData/Book1.xlsx";

        FileInputStream input = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(input);
        Sheet sheet = workbook.getSheet("Лист1");

        String firstName = sheet.getRow(1).getCell(0).toString();
        System.out.println("firstName: " + firstName);

        sheet.getRow(1).getCell(0).setCellValue("Kim");

        FileOutputStream output = new FileOutputStream(path);
        workbook.write(output);

        firstName = sheet.getRow(1).getCell(0).toString();
        System.out.println(firstName);
        System.out.println("firstName: " + firstName);

        sheet.getRow(1).getCell(1).setCellValue("Pitt");
        workbook.write(output);
        output.close();
    }

}
