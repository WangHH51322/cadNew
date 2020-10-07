package result;

import org.kabeja.parser.ParseException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static data.MathMethod.addPlugIntoNode;
import static data.MathMethod.removePlug;
import static data.NetWork.nodeintegration;
import static data.NetWork.pipeintegration;
import static data.PlugCalculate.addPlug;
import static data.PlugCalculate.getPlug;
import static data.ReadCad.nodesData;
import static data.ReadCad.pipesData;
import static data.ValveCalculate.*;
import static data.ValveCalculate.doubleValve;
import static data.ValveCalculate.singleValve;
import static data.ValveCalculate.tribleValve;
import static result.InPut.blockContact;
import static result.InPut.nodeContact;
import static result.InPut.pipeContact;


/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 18:48
 */
public class Result {

    public static List<String> getResult(String dataPath,List<String> layerName) throws FileNotFoundException, ParseException {

        double distance = 1;

        List<String> errors = new ArrayList<>();

        //将各个图层的管段合并到一起
        List<List<String>> pipe = pipeContact(dataPath,layerName);
        List<List<String>> node = nodeContact(dataPath,layerName);

        //读取块参数,参数格式:<块编号,块数目,块外框左下角x,块外框左下角y,块外框右上角x,块外框右上角y>
        List<List<String>> block = blockContact(dataPath);

        //根据node与pipe之间的关系,将管段自动分段
        List<List<String>> pipes = pipesData(pipe,node);
        //将管段起终点拆开组成节点数组
        List<List<String>> nodes = nodesData(pipes);

        //对节点进行编号,标注节点类型
        List<List<String>> nodeList = nodeintegration(nodes);
        //对管段编号,起终点编号,标注管段类型
        List<List<String>> pipeList = pipeintegration(nodes,pipes);

        //从所有块对象中分别获取加油栓和地井阀
        List<List<String>> plug = getPlug(block);
        System.out.println("加油栓:" + plug);
        System.out.println("加油栓的数目" + plug.size());
        int m = plug.size();
        List<List<String>> valve = getValve(block);
        System.out.println("地井阀:" + valve);
        System.out.println("地井阀的数目" + valve.size());

        System.out.println("不考虑阀门时的管段:" + pipeList);
        System.out.println("不考虑阀门时的节点:" + nodeList);
        System.out.println("不考虑阀门时的管段数目:" + pipeList.size());

        System.out.println("不考虑阀门时的节点数目:" + nodeList.size());

        System.out.println("*************************************");


        //将单阀的坐标加到listTest中去,判断单阀在哪条管段上,并将单阀所在的管段拆分成两根管段加到总管段数中去
        //删除原有管段,并重新对管段进行编号
        System.out.println("加入单阀后的管段:" + singleValve(valve,nodeList,pipeList,errors));
        System.out.println("加入单阀后管段数目:" + pipeList.size());
        System.out.println("加入单阀后的节点" + nodeList);
        System.out.println("加入单阀后节点数目:" + nodeList.size());
        System.out.println("加入单阀后的误差" + errors);
        System.out.println("*************************************");




        //将双阀地井阀的外框坐标加到valveTwo中去
        //valveTwo:<地井阀名称,起点x,起点y,终点x,终点y,地井阀的中心坐标x,中心坐标y>
        //判断哪些节点在地井阀中
        //判断地井阀中心点与节点的相对位置
        //并根据相对位置,确定具体阀的位置
        System.out.println("加入双阀地井阀后的管段:" + doubleValve(valve,nodeList,pipeList,distance,errors));
        System.out.println("加入双阀地井阀后管段数目:" + pipeList.size());
        System.out.println("加入双阀地井阀后的节点:" + nodeList);
        System.out.println("加入双阀地井阀后节点数目:" + nodeList.size());
        System.out.println("加入双阀后的误差" + errors);
        System.out.println("*************************************");


        //将双阀地井阀的外框坐标加到valveThree中去
        //valveThree:<地井阀名称,起点x,起点y,终点x,终点y,地井阀的中心坐标x,中心坐标y>
        //判断哪些节点在地井阀中
        //判断地井阀中心点与节点的相对位置
        //并根据相对位置,确定具体阀的位置
//        System.out.println("加入三阀地井阀后的管段:" + tribleValve(valve, nodeList, pipeList,distance,errors));
//        System.out.println("加入三阀地井阀后管段数目:" + pipeList.size());
//        System.out.println("加入三阀地井阀后的节点" + nodeList);
//        System.out.println("加入三阀地井阀后节点数目:" + nodeList.size());
//        System.out.println("加入三阀后的误差" + errors);
//        System.out.println("*************************************");


        //判断加油栓是否在节点上,并更改节点名称
//        addPlugIntoNode(plug,nodeList);
        //将与节点重合的加油栓从加油栓数组中删去
//        List<List<String>> newPlug = removePlug(plug,nodeList);
//        System.out.println("不重合加油栓个数:" + newPlug.size());
//
//        System.out.println("加入加油栓后的管段" + addPlug(newPlug, nodeList, pipeList));
//        System.out.println("加入加油栓后管段数目:" + pipeList.size());
//        System.out.println("加入加油栓后的节点" + nodeList);
//        System.out.println("加入加油栓后节点数目:" + nodeList.size());
//        System.out.println("*************************************");

//        dataExcel(pipeList,excelPath,pipeSheetName);
//        dataExcel(nodeList,excelPath,nodeSheetName);
        return errors;
    }


}
