package test;


import org.kabeja.parser.ParseException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static result.Result.getResult;
import static result.ResultJson.getResultJson;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 15:17
 */
public class test021 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        //.dxf文件存放的路径
        String dataPath = "D:\\data\\test1.dxf";

        //需要读取的管段所在的图层名称,目前支持最多5个图层
        List<String> LayerNames = new ArrayList<>();
        LayerNames.add("--GY-DN150");
        LayerNames.add("--GY-管道DN450");

        //结果输出(从左到右参数依次为:.dxf文件存放的路径;需要读取的管段所在的图层名称;输出数据excel存放的路径;管段数据存放的sheet;节点数据存放的sheet;阀与节点距离)
        LastRead(dataPath, LayerNames);
    }

    public static void LastRead(String dataPath, List<String> LayerNames) throws FileNotFoundException, ParseException{

        getResultJson(dataPath, LayerNames,dataPath);
    }
}
