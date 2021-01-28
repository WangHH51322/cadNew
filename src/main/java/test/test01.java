package test;

import org.kabeja.parser.ParseException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static error.ExcludeError.errorPipeFirst;
import static excel.Out2Excel.dataExcel;
import static result.InPut.*;
import static result.InPut.blockContact;
import static result.InPut.blockContact;
import static result.InPut.blockContact;
import static result.InPut.blockContact;
import static result.InPut.nodeContact;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 18:25
 */
public class test01 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        //.dxf文件存放的路径
        String dataPath = "C:\\Users\\WangHH\\Desktop\\机场CAD\\v04.dxf";
//        String dataPath = "D:\\data\\test1.dxf";

        //需要读取的管段所在的图层名称,目前支持最多5个图层

        List<String> LayerNames = new ArrayList<>();
        LayerNames.add("GY-DN150");
        LayerNames.add("GY-DN400");
        LayerNames.add("GY-DN500");
        LayerNames.add("GY-DN600");
//        LayerNames.add("--GY-阀门井");
//        LayerNames.add("--GY-阀门井");
//        LayerNames.add("--GY-管道DN450");
        List<String> s = FirstRead(dataPath,LayerNames);
        System.out.println(s);


    }
    public static List<String> FirstRead(String dataPath, List<String> LayerNames) throws FileNotFoundException, ParseException{

        //读取块参数,参数格式:<块编号,块数目,块外框左下角x,块外框左下角y,块外框右上角x,块外框右上角y>
        List<List<String>> block = blockContact(dataPath);
        System.out.println(block);
        System.out.println("所有块对象的个数为:" + block.size());

        //将各个图层的管段合并到一起
        List<List<String>> pipe = pipeContact(dataPath,LayerNames);
        List<List<String>> node = nodeContact(dataPath,LayerNames);
//
//        String excelPath = "C:\\Users\\WangHH\\Desktop\\机场CAD\\dataPipe.xlsx";
//        String pipeSheetName = "pipe01";
//        dataExcel(pipe,excelPath,pipeSheetName);

        //管段自动排错
        List<String> error = errorPipeFirst(pipe);
        if(error.size() == 0){
            String noError = "预读取无问题，可直接输出结果！";
            error.add(noError);
        }
        return error;
    }

}
