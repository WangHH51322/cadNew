package excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 13:32
 */
public class Out2Excel {

    public static void dataExcel (List<List<String>> List , String dataPath , String sheetName){
        XSSFWorkbook outputWorkbook;
        outputWorkbook = DataRead.getWorkbook(dataPath);
        try {
            XSSFSheet pipeResultsSheet = outputWorkbook.getSheet(sheetName);
            for (int i = 0; i < List.size(); i++) {
                if (pipeResultsSheet.getRow(i+1) == null) {
                    pipeResultsSheet.createRow(i);
                }
                for (int j = 0; j < List.get(i).size(); j++) {
                    if (pipeResultsSheet.getRow(i).getCell(j) == null) {
                        pipeResultsSheet.getRow(i).createCell(j);
                    }
                    pipeResultsSheet.getRow(i).getCell(j).setCellValue(List.get(i).get(j));
                }
            }

            OutputStream outputStream = new FileOutputStream(dataPath);
            outputWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (
                FileNotFoundException e1) {
            System.out.println("找不到文件！");
        } catch (
                IOException e2) {
            System.out.println("文件打开出错！");
        }
    }

}
