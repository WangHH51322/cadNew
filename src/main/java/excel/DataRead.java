package excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 13:29
 */
public class DataRead {

    public static XSSFWorkbook getWorkbook (String path) {

        try {
            InputStream inputStream = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            inputStream.close();
            return workbook;
        } catch (FileNotFoundException e1) {
            System.out.println("找不到文件！");
        } catch (IOException e2) {
            System.out.println("文件打开出错！");
        }
        return null;

    }

}
